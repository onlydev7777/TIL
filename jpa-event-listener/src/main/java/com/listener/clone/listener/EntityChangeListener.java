package com.listener.clone.listener;

import jakarta.persistence.PreUpdate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class EntityChangeListener {
//    @Lazy
//    @Autowired
//    private AsyncEntityChangeHandler listenerComponent;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @SneakyThrows
    @PreUpdate
    public void preUpdate(Object trackableEntity){
        eventPublisher.publishEvent(new EntityChangeEvent(trackableEntity));
//        listenerComponent.handlePreUpdate(trackableEntity);

//        if (trackableEntity instanceof Member member){
//            // Hibernate Session 객체 가져오기
//            // Hibernate SessionFactory 추출
//            SessionFactory sessionFactory = emf.unwrap(SessionFactory.class);
//
//            // Hibernate Session 추출
//            Session session = sessionFactory.getCurrentSession();
//
//            // Session을 SharedSessionContractImplementor로 변환
//            if (!(session instanceof SharedSessionContractImplementor)) {
//                throw new IllegalStateException("Session is not a valid Hibernate session.");
//            }
//
//            SharedSessionContractImplementor sessionImpl = (SharedSessionContractImplementor) session;
//
//            // Hibernate의 PersistenceContext 가져오기
//            PersistenceContext persistenceContext = sessionImpl.getPersistenceContext();
//
//            // 엔터티 메타데이터 가져오기
//            EntityPersister entityPersister = sessionImpl.getEntityPersister(member.getClass().getName(), member);
//
//            // 엔터티 식별자 가져오기
//            Object identifier = entityPersister.getIdentifier(member, sessionImpl);
//
//            // 엔터티의 스냅샷 데이터 가져오기
//            Object[] entitySnapshot = persistenceContext.getDatabaseSnapshot(identifier, entityPersister);
//            if (entitySnapshot == null) {
//                throw new IllegalStateException("Entity is not managed or no snapshot is available.");
//            }
//
//            // 스냅샷 데이터와 엔티티의 프로퍼티 이름 매핑
//            String[] propertyNames = entityPersister.getPropertyNames();
//            Map<String, Object> snapshotMap = new HashMap<>();
//            ObjectMapper objectMapper = new ObjectMapper();
//            for (int i = 0; i < propertyNames.length; i++) {
//                snapshotMap.put(propertyNames[i], entitySnapshot[i]);
//                log.info("propertyName : {}, member : {}", propertyNames[i], objectMapper.writeValueAsString(entitySnapshot[i]));
//            }
//        }
    }
}
