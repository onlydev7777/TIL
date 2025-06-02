package com.multitenant.service;

import com.multitenant.entity.Member;
import com.multitenant.entity.Team;
import com.multitenant.repository.MemberRepository;
import com.multitenant.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository repository;
    private final TeamRepository teamRepository;
    private final AdminUserService adminUserService;
    private final JdbcTemplate jdbcTemplate;

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

    public String findByNameWithJdbcTemplate(String name) {
        return jdbcTemplate.queryForObject("select * from members where member_nm = ?",
                (rs, rowNum) -> rs.getString("member_nm"),
                name
        );
    }

    @Transactional
    public String saveWithJdbcTemplate(String teamName, String memberName) {
        Long teamId = jdbcTemplate.queryForObject("select id from team where team_nm = ?",
                (rs, rowNum) -> rs.getLong("id"),
                teamName
        );

        log.info("teamId ::: {}", teamId);

        if(teamId == null) {
            jdbcTemplate.update("INSERT INTO team values (nextval('team_seq'), ?)", teamName);

            teamId = jdbcTemplate.queryForObject("select id from team where team_nm = ?",
                    (rs, rowNum) -> rs.getLong("id"),
                    teamName
            );

            log.info("New teamId ::: {}", teamId);
        }

        jdbcTemplate.update("INSERT INTO members values (nextval('members_seq'), ?, ?)",
                teamId,
                memberName);

        return memberName;
    }
}
