package com.abstractservice.service.strategy;

import com.abstractservice.entity.Member;
import com.abstractservice.service.onpremise.HyundaiMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Profile("hyundai")
@RequiredArgsConstructor
@Component
public class HyundaiMemberStrategy implements MemberStrategy {

  private final HyundaiMemberService service;

  @Override
  public Member findById(Long id) {
    log.info("======== HyundaiMemberStrategy.findById call ========");
    return service.findById_Hyundai(id);
  }
}
