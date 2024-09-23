package com.abstractservice.service;

import com.abstractservice.entity.Member;
import com.abstractservice.service.strategy.MemberStrategy;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@RequiredArgsConstructor
@Service
public class DelegatingMemberService implements MemberService {

  private final MemberService memberService;
  private final MemberStrategy memberStrategy;

  @Override
  public Member findById(Long id) {
//    if (memberService instanceof SamsungMemberService sms) {
//      return sms.findById_Samsung(id);
//    } else if (memberService instanceof HyundaiMemberService hms) {
//      return hms.findById_Hyundai(id);
//    }

//    return memberService.findById(id);
    return memberStrategy.findById(id);
  }

  @Override
  public List<Member> findAll() {
    return memberService.findAll();
  }

  @Override
  public Member save(String name) {
    return memberService.save(name);
  }
}
