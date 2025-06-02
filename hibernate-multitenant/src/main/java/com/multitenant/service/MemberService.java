package com.multitenant.service;

import com.multitenant.entity.Member;
import com.multitenant.entity.Team;
import com.multitenant.repository.MemberRepository;
import com.multitenant.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository repository;
    private final TeamRepository teamRepository;
    private final AdminUserService adminUserService;

    @Transactional
    public String save(String teamName, String name) {
        Team team = teamRepository.findByName(teamName).orElseGet(() ->
                teamRepository.save(new Team(teamName))
        );
        return repository.save(new Member(team, name)).getName();
    }

    @Transactional
    public String saveWithNative(String teamName, String name) {
        Team team = teamRepository.findByNameWithNative(teamName).orElseGet(() ->
                teamRepository.save(new Team(teamName))
        );
        return repository.save(new Member(team, name)).getName();
    }

    @Transactional
    public String saveWithAdmin(String teamName, String name) {
        Team team = teamRepository.findByName(teamName).orElseGet(() ->
                teamRepository.save(new Team(teamName))
        );
        String result = repository.save(new Member(team, name)).getName();

        adminUserService.save(name, teamName);

        return result;
    }

    @Transactional
    public String saveWithAdminButException(String teamName, String name) {
        Team team = teamRepository.findByName(teamName).orElseGet(() ->
                teamRepository.save(new Team(teamName))
        );
        String result = repository.save(new Member(team, name)).getName();

        adminUserService.save(name, teamName);
        throw new RuntimeException("런타임 오류!!");
    }

    public String findByName(String name) {
        return repository.findByName(name).getName();
    }

    public String findByNameWithTeam(String teamName, String name) {
        Team team = null;
        if(teamName != null) {
            team = teamRepository.findByName(teamName).orElseThrow();
        }
        return repository.findByNameWithTeam(team, name).getName();
    }

    public String findByNameWithNative(String name) {
        return repository.findByNameWithNative(name).getName();
    }
}
