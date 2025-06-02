package com.multitenant.service;

import com.multitenant.entity.AdminUser;
import com.multitenant.repository.AdminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminUserService {
    private final AdminUserRepository repository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(String name, String teamName) {
        repository.save(new AdminUser(name, teamName));
    }

    @Transactional(readOnly = true)
    public String findByName(String name) {
        return repository.findByName(name)
                .map(AdminUser::getName)
                .orElse("NOT Admin User");
    }
}
