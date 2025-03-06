package com.jpatest.domain.manytoone.repository;

import com.jpatest.domain.manytoone.Member;
import com.jpatest.domain.manytoone.Team;
import com.jpatest.domain.manytoone.TeamFlatDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


/**
 * ColumnTransformer 에서 where 절은 자동으로 read 속성으로 변환 됨.
 * -> 인덱스 설정할 때 이슈가 있을 수 있음
 * -> 어거지로 조건절 파라미터에 encrypt 넣고 싶으면 nativeQuery 속성 사용하는 수 밖에 없음...;;
 */
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ColumnTransformerTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @DisplayName("@ColumnTransformer Same Columns Read Check")
    @Test
    void readCheck() throws Exception {
        Team aTeam = new Team("A");

        teamRepository.save(aTeam);

        Member member1 = new Member(aTeam, "홍길동");
        Member member2 = new Member(aTeam, "김길동");

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<TeamFlatDto> flatDtos = memberRepository.findFlatDto(aTeam.getId());

        assertThat(flatDtos).extracting("teamName")
                .containsOnly("A");

        assertThat(flatDtos).extracting("memberName")
                .contains("홍길동", "김길동");
    }

    @DisplayName("@ColumnTransformer Same Columns Where Check")
    @Test
    void whereCheck() throws Exception {
        Team aTeam = new Team("A");

        teamRepository.save(aTeam);

        Member member1 = new Member(aTeam, "홍길동");
        Member member2 = new Member(aTeam, "김길동");

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<TeamFlatDto> flatDtos = memberRepository.findFlatDtoByName("A", "홍길동");

        assertThat(flatDtos).extracting("teamName")
                .containsOnly("A");

        assertThat(flatDtos).extracting("memberName")
                .containsOnly("홍길동");
    }

//    @Disabled
    @DisplayName("@ColumnTransformer Same Columns Where With Encrypt Check")
    @Test
    void whereEncryptCheck() throws Exception {
        Team aTeam = new Team("A");

        teamRepository.save(aTeam);

        Member member1 = new Member(aTeam, "홍길동");
        Member member2 = new Member(aTeam, "김길동");

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<TeamFlatDto> flatDtos = memberRepository.findFlatDtoByNameWithEncrypt("A", "홍길동");

        assertThat(flatDtos).extracting("teamName")
                .containsOnly("A");

        assertThat(flatDtos).extracting("memberName")
                .containsOnly("홍길동");
    }
}
