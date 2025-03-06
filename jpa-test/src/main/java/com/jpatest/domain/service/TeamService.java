package com.jpatest.domain.service;

import com.jpatest.domain.manytoone.Team;
import com.jpatest.domain.manytoone.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final TeamRepository repository;

    @Transactional
    public void save(String name){
        Team aTeam = new Team(name);
        repository.saveAndFlush(aTeam);
    }
}
