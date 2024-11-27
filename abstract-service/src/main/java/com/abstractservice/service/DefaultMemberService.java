package com.abstractservice.service;

import com.abstractservice.entity.Member;
import com.abstractservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
//@Profile("default")
@RequiredArgsConstructor
@Transactional(readOnly = true)
//@Service
public class DefaultMemberService implements MemberService {

  protected final MemberRepository repository;

  @Override
  public Member findById(Long id) {
    log.info("DefaultMemberService.findById");
    log.info("{} findById call", this);

    return repository.findById(id)
        .orElse(null);
  }

  @Override
  public List<Member> findAll() {
    return repository.findAll();
  }

  @Override
  @Transactional
  public Member save(String name) {
    return repository.save(new Member(name));
  }
}
