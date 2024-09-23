package com.abstractservice.service.strategy;

import com.abstractservice.entity.Member;
import com.abstractservice.service.DefaultMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Profile("default")
@RequiredArgsConstructor
@Component
public class DefaultMemberStrategy implements MemberStrategy {

  private final DefaultMemberService service;

  @Override
  public Member findById(Long id) {
    return service.findById(id);
  }
}
