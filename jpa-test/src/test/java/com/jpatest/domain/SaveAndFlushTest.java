package com.jpatest.domain;

import com.jpatest.domain.manytoone.Member;
import com.jpatest.domain.manytoone.Team;
import com.jpatest.domain.manytoone.repository.MemberRepository;
import com.jpatest.domain.manytoone.repository.TeamRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SaveAndFlushTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @DisplayName("@ColumnTransformer Same Columns Read Check")
    @Test
    void readCheck() throws Exception {
        Team aTeam = new Team("A");
        Team bTeam = new Team("B");

        teamRepository.saveAndFlush(aTeam);
        teamRepository.save(bTeam);

        Member member1 = new Member(aTeam, "홍길동");
        Member member2 = new Member(aTeam, "김길동");

        memberRepository.saveAndFlush(member1);
        memberRepository.save(member2);
    }
}
