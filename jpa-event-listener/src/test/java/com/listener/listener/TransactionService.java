package com.listener.listener;

import com.listener.FieldRandomSetter;
import com.listener.clone.entity.Member;
import com.listener.clone.repository.MemberHistoryRepository;
import com.listener.clone.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class TransactionService {
    @Autowired
    MemberHistoryRepository memberHistoryRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void memberUpdateByNewTransaction() {
        List<Member> members = memberRepository.findAll();
        long start = System.currentTimeMillis();
        for (Member findMember : members) {
            boolean isPersistence = em.contains(findMember);
            log.info("isPersistence : " + isPersistence);
            findMember.createSnapshot("이사하면서 자산증가");
            findMember.changeAddress("서울특별시"+FieldRandomSetter.generateRandomString(10));
            findMember.updateAssets(BigDecimal.valueOf(2000));

            FieldRandomSetter.setRandomValues(findMember);
            em.flush();
        }

        long end = System.currentTimeMillis();
        log.info("clone 방식 : {} ms", (end-start));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void init(final int MEMBER_CNT){
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
        em.flush();
    }
}
