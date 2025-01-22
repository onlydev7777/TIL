package com.listener.clone.listener;

import com.listener.annotation.Trackable;
import com.listener.clone.entity.MemberHistory;
import com.listener.trackable.AbstractTrackable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PreUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class MemberListener {
    @Lazy
    @Autowired
    private EntityManager em;

    @PreUpdate
    public void preUpdate(Object trackableEntity){
        if (trackableEntity instanceof AbstractTrackable trackable) {
            Object snapshot = trackable.getSnapshot();
            List<MemberHistory> memberHistories = new ArrayList<>();
            LocalDateTime now = LocalDateTime.now();

            for (Field field : snapshot.getClass().getDeclaredFields()) {
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
