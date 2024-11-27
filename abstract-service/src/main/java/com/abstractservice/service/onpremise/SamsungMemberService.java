package com.abstractservice.service.onpremise;

import com.abstractservice.entity.Member;
import com.abstractservice.repository.MemberRepository;
import com.abstractservice.service.DefaultMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
//@Profile("samsung")
@Transactional(readOnly = true)
//@Service
public class SamsungMemberService extends DefaultMemberService {

  public SamsungMemberService(MemberRepository repository) {
    super(repository);
  }

  
  @Override
  public List<Member> findAll() {
    log.info("==== decorator before logic ====");
    List<Member> all = super.findAll();
    log.info("==== decorator after logic ====");
    return all;
  }

  public Member findById_Samsung(Long id) {
    log.info("SamsungMemberService.findById_Samsung", this);
    Member member = repository.findById(id).orElseThrow();

    return member;
  }
}
