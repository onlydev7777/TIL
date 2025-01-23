package com.listener;

import java.lang.reflect.Field;
import java.util.Random;

public class FieldRandomSetter {
    public static void setRandomValues(Object member) {
        Field[] fields = member.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().startsWith("field")) { // field1~field133 필드만 처리
                try {
                    String randomValue = generateRandomString(10); // 랜덤 알파벳 문자열 생성
                    field.set(member, randomValue);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to set random value for field: " + field.getName(), e);
                }
            }
        }
    }

    public static String generateRandomString(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('a' + random.nextInt(26)); // 소문자 알파벳 생성
            builder.append(randomChar);
        }
        return builder.toString();
    }
}
