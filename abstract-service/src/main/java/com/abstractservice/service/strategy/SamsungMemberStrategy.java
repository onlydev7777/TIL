package com.abstractservice.service.strategy;

import com.abstractservice.entity.Member;
import com.abstractservice.service.onpremise.SamsungMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Profile("samsung")
@RequiredArgsConstructor
@Component
public class SamsungMemberStrategy implements MemberStrategy {

  private final SamsungMemberService service;

  @Override
  public Member findById(Long id) {
    return service.findById_Samsung(id);
  }
}
