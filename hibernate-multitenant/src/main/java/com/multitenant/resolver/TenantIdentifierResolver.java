package com.multitenant.resolver;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {
    public static final String DEFAULT_SCHEMA = "newbp_local2";

    @Override
    public String resolveCurrentTenantIdentifier() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String requestURI = request.getRequestURI();
            String[] uriOrder = requestURI.split("/");
            return uriOrder.length > 1 ? uriOrder[1] : requestURI;
        }

        return DEFAULT_SCHEMA;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
