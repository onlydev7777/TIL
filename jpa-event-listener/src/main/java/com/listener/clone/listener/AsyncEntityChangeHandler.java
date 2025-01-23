package com.listener.clone.listener;

import com.listener.annotation.Trackable;
import com.listener.clone.entity.MemberHistory;
import com.listener.trackable.AbstractTrackable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class AsyncEntityChangeHandler {
   @PersistenceContext
   private EntityManager em;

    private static final Map<Class<?>, List<Field>> TRACKABLE_FIELDS_CACHE = new ConcurrentHashMap<>();

    private List<Field> getTrackableFields(Class<?> clazz) {
        return TRACKABLE_FIELDS_CACHE.computeIfAbsent(clazz, cls -> {
            log.info("getTrackableFields >> call >> gogogo!!");
            List<Field> trackableFields = new ArrayList<>();
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Trackable.class)) {
                    field.setAccessible(true);
                    trackableFields.add(field);
                }
            }
            return trackableFields;
        });
    }

   @Async
   @EventListener
   @Transactional(propagation = Propagation.REQUIRES_NEW)
   public void handlePreUpdate(EntityChangeEvent entityChangeEvent) {

        Object trackableEntity = entityChangeEvent.getTrackableEntity();

        if (trackableEntity instanceof AbstractTrackable trackable) {
            Object snapshot = trackable.getSnapshot();
            LocalDateTime now = LocalDateTime.now();

            List<Field> fields = getTrackableFields(snapshot.getClass());

//            for (Field field : snapshot.getClass().getDeclaredFields()) {
            for (Field field : fields) {
                if (field.isAnnotationPresent(Trackable.class)) {
                    field.setAccessible(true);
                    Object oldValue = null;
                    Object newValue = null;
                    try {
                        oldValue = field.get(snapshot);
                        newValue = field.get(trackableEntity);
                    } catch (IllegalAccessException e) {
                        log.error(e.getMessage(), e);
                    }

                    if (newValue != null && !newValue.equals(oldValue)) {
                        MemberHistory history = MemberHistory.builder()
                                .entityId(trackable.getId())
                                .entityType(trackable.getEntityType())
                                .fieldName(field.getName())
                                .changeReason(trackable.getChangeReason())
                                .oldValue(oldValue.toString())
                                .newValue(newValue.toString())
                                .modDttm(now)
                                .build();

                        em.persist(history);
                    }
                }
            }
        }
   }
}
