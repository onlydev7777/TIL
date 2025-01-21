package com.listener.clone.listener;

import com.listener.annotation.Trackable;
import com.listener.clone.entity.Member;
import com.listener.clone.entity.MemberHistory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MemberCloneListener {
    @Lazy
    @Autowired
    private EntityManager em;

    @PreUpdate
    public void preUpdate(Member member){
        Member snapshot = member.getSnapshot();
        List<MemberHistory> memberHistories = new ArrayList<>();

        Long id = member.getId();
        String name = member.getName();
        BigDecimal assets = member.getAssets();
        String addr = member.getAddr();

        for (Field field : snapshot.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Trackable.class)) {
                field.setAccessible(true);
                Object oldValue = null;
                Object newValue = null;
                try {
                    oldValue = field.get(snapshot);
                    newValue = field.get(member);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

                if (oldValue != null && !oldValue.equals(newValue)) {
                    MemberHistory history = MemberHistory.builder()
                            .memberId(member.getId())
                            .fieldName(field.getName())
                            .changeReason(member.getChangeReason())
                            .oldValue(oldValue.toString())
                            .newValue(newValue.toString())
                            .modDttm(LocalDateTime.now())
                            .build();

//                    memberHistories.add(history);
                    em.persist(history);
                }
            }
        }
//        historyRepository.saveAll(memberHistories);

    }
}
