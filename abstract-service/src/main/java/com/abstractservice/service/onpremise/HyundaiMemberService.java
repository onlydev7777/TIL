package com.abstractservice.service.onpremise;

import com.abstractservice.entity.Member;
import com.abstractservice.repository.MemberRepository;
import com.abstractservice.service.DefaultMemberService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Profile("hyundai")
@Transactional(readOnly = true)
@Service
public class HyundaiMemberService extends DefaultMemberService {

  public HyundaiMemberService(MemberRepository repository) {
    super(repository);
  }

  @Override
  public List<Member> findAll() {
    log.info("==== decorator before logic ====");
    List<Member> all = super.findAll();
    log.info("==== decorator after logic ====");
    return all;
  }

  public Member findById_Hyundai(Long id) {
    System.out.println("HyundaiMemberService.findById_Hyundai");
    log.info("{} findById_Hyundai call", this);
    Member member = repository.findById(id).orElseThrow();

    return member;
  }
}
