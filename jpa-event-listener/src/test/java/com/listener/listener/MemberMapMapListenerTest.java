package com.listener.listener;

import com.listener.FieldRandomSetter;
import com.listener.clone.entity.Member;
import com.listener.clone.entity.MemberHistory;
import com.listener.clone.repository.MemberHistoryRepository;
import com.listener.clone.repository.MemberRepository;
import com.listener.map.entity.MemberMap;
import com.listener.map.repository.MemberMapRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

//@EnableSpringConfigured

@Slf4j
@Transactional
@SpringBootTest
class MemberMapMapListenerTest {
    @Autowired
    MemberMapRepository memberMapRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberHistoryRepository memberHistoryRepository;

    @Autowired
    EntityManager em;

    private final int MEMBER_CNT = 1000;

    @Rollback(false)
    @DisplayName("[Map방식] 멤버가 변경되면 Listener가 동작한다 : 30027 ms")
    @Test
    void 멤버가_변경되면_Map_Listener가_동작한다() throws Exception {
        memberHistoryRepository.deleteAll();
        for (int i = 0; i < MEMBER_CNT; i++) {
            MemberMap memberMap = MemberMap.builder()
                    .addr("경기도광명시")
                    .age(30)
                    .assets(BigDecimal.valueOf(1000))
                    .name("홍길동")
                    .build();

            FieldRandomSetter.setRandomValues(memberMap);
            em.persist(memberMap);
        }

        List<MemberMap> members = memberMapRepository.findAll();

        long start = System.currentTimeMillis();
        for (MemberMap findMember : members) {
            findMember.saveSnapshot();
            findMember.changeAddress("서울특별시", "주소변경");
            findMember.updateAssets(BigDecimal.valueOf(2000), "자산변경1");

            FieldRandomSetter.setRandomValues(findMember);
            em.flush();
        }
        long end = System.currentTimeMillis();

        log.info("map 방식 : {} ms", (end-start));

        List<MemberHistory> histories = memberHistoryRepository.findAll();
        assertThat(histories).hasSize(MEMBER_CNT*102);
    }

    @Rollback(false)
    @DisplayName("[clone방식] 멤버가 변경되면 Listener가 동작한다 : 29163 ms")
    @Test
    void 멤버가_변경되면_Clone_Listener가_동작한다() throws Exception {
        memberHistoryRepository.deleteAll();
        for (int i = 0; i < MEMBER_CNT; i++) {
            Member member = Member.builder()
                    .addr("경기도광명시")
                    .age(30)
                    .assets(BigDecimal.valueOf(1000))
                    .name("홍길동")
                    .build();

            FieldRandomSetter.setRandomValues(member);
            em.persist(member);
        }


        List<Member> members = memberRepository.findAll();

        long start = System.currentTimeMillis();
        for (Member findMember : members) {
            findMember.createSnapshot("이사하면서 자산증가");
            findMember.changeAddress("서울특별시", "주소변경");
            findMember.updateAssets(BigDecimal.valueOf(2000), "자산변경1");

            FieldRandomSetter.setRandomValues(findMember);
//            memberRepository.save(findMember);
//            memberRepository.saveAndFlush(findMember);
            em.flush();
        }
        long end = System.currentTimeMillis();

        log.info("clone 방식 : {} ms", (end-start));

        //비동기 방식 대기... 테스트 코드 단순화
        Thread.sleep(1000);

        List<MemberHistory> histories = memberHistoryRepository.findAll();
        assertThat(histories).hasSize(MEMBER_CNT*102);
    }
}
