package com.multitenant.service;

import com.multitenant.entity.Team;
import com.multitenant.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class TeamService {
    private final TeamRepository repository;

    @Transactional
    public String save(String teamName) {
        return repository.save(new Team(teamName)).getName();
    }

    public String findByName(String name) {
        return repository.findByName(name).orElseThrow().getName();
    }
}
