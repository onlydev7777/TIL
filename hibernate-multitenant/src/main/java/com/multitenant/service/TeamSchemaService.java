package com.multitenant.service;

import com.multitenant.entity.TeamSchema;
import com.multitenant.repository.TeamSchemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class TeamSchemaService {
    private final TeamSchemaRepository repository;

    public List<String> findSchemaNameList() {
        return repository.findAll().stream()
                .map(TeamSchema::getSchemaName)
                .toList();
    }

    public List<TeamSchema> findSchemaList() {
        return repository.findAll();
    }
}
