package com.multitenant.context;

public class TenantContext extends ThreadLocal<String> {
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

    // 회사(스키마) 정보 설정
    public static void setTenant(String tenant) {
        currentTenant.set(tenant);
    }

    // 현재 스키마 정보 조회
    public static String getTenant() {
        return currentTenant.get();
    }

    // 세션 종료 후 Tenant 정보 제거
    public static void clear() {
        currentTenant.remove();
    }
}
