package com.multitenant.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multitenant.context.TenantContext;
import com.multitenant.entity.Member;
import com.multitenant.entity.Team;
import com.multitenant.entity.TeamSchema;
import com.multitenant.entity.TempMember;
import com.multitenant.repository.MemberRepository;
import com.multitenant.repository.TeamRepository;
import com.multitenant.repository.TeamSchemaRepository;
import com.multitenant.repository.TempMemberRepository;
import com.multitenant.resolver.TenantIdentifierResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class TempMemberService {
    private final TempMemberRepository repository;
    private final TeamSchemaRepository teamSchemaRepository;
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sync(String teamName) throws JsonProcessingException {
        List<Team> findAll = teamRepository.findAll();
        List<TeamSchema> findAll2 = teamSchemaRepository.findAll();
        String findAllData = objectMapper.writeValueAsString(findAll);
        String findAllData2 = objectMapper.writeValueAsString(findAll2);

        List<Map<String, Object>> templateMap = jdbcTemplate.queryForList("select * from team");
        List<Map<String, Object>> templateMap2 = jdbcTemplate.queryForList("select * from "+ TenantIdentifierResolver.DEFAULT_SCHEMA +".team_schema");
        String templateData = objectMapper.writeValueAsString(templateMap);
        String templateData2 = objectMapper.writeValueAsString(templateMap2);

        log.info("TEST::: schema ::: {} findAllData ::: Team ::: {}", TenantContext.getTenant(), findAllData);
        log.info("TEST::: schema ::: {} templateData ::: Team ::: {}", TenantContext.getTenant(), templateData);
        log.info("TEST::: schema ::: {} findAllData ::: TeamSchema ::: {}", TenantContext.getTenant(), findAllData2);
        log.info("TEST::: schema ::: {} templateData ::: TeamSchema ::: {}", TenantContext.getTenant(), templateData2);

        List<TempMember> tempMembers = repository.findAllByTeamName(teamName);
        for (TempMember tempMember : tempMembers) {
            Team team = teamRepository.findByName(tempMember.getTeamName()).orElseThrow();
            Member findMember = memberRepository.findByNameWithTeam(team, tempMember.getName());
            if (findMember == null) {
                memberRepository.save(new Member(team, tempMember.getName()));
            }
        }
    }
}
