package com.multitenant.service;

import com.multitenant.entity.Member;
import com.multitenant.entity.Team;
import com.multitenant.entity.TempMember;
import com.multitenant.repository.MemberRepository;
import com.multitenant.repository.TeamRepository;
import com.multitenant.repository.TempMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TempMemberService {
    private final TempMemberRepository repository;
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sync(String teamName) {
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
