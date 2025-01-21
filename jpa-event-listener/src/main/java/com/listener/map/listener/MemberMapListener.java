package com.listener.map.listener;

import com.listener.map.entity.MemberMap;
import com.listener.map.entity.MemberMapHistory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PreUpdate;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;


public class MemberMapListener {
    @Lazy
    @Autowired
    private EntityManager em;

    @PreUpdate
    public void preUpdate(MemberMap memberMap){
        Long id = memberMap.getId();
        String name = memberMap.getName();
        BigDecimal assets = memberMap.getAssets();
        String addr = memberMap.getAddr();

        Map<String, Object> snapshot = memberMap.getSnapshot();
        if(snapshot.isEmpty()){
            return ;
        }

        for (Map.Entry<String, Object> entry : snapshot.entrySet()) {
            String fieldName = entry.getKey();
            Object oldValue = entry.getValue();
            Object newValue = resolveFieldValue(memberMap, fieldName);

            if (newValue != null && !newValue.equals(oldValue)) {
                MemberMapHistory history = MemberMapHistory.builder()
                        .memberId(memberMap.getId())
                        .fieldName(fieldName)
                        .changeReason(memberMap.getChangeReason())
                        .oldValue(String.valueOf(oldValue))
                        .newValue(String.valueOf(newValue))
                        .modDttm(LocalDateTime.now())
                        .build();

                em.persist(history);
            }
        }
    }

    @SneakyThrows
    private Object resolveFieldValue(Object target, String fieldName) {
        // 필드 이름을 점(.) 기준으로 분리하여 중첩 구조 처리
        String[] fieldParts = fieldName.split("\\.");
        Object currentObject = target;

        for (String part : fieldParts) {
            if (currentObject == null) {
                return null; // 중간에 null 객체가 발견되면 null 반환
            }

            // 현재 객체의 클래스에서 필드 조회
            Field field = currentObject.getClass().getDeclaredField(part);
            field.setAccessible(true); // private 필드에 접근 가능하도록 설정
            currentObject = field.get(currentObject); // 필드 값을 가져와 다음 단계로 이동
        }

        return currentObject;
    }
}
