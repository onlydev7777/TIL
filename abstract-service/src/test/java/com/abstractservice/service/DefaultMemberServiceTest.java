package com.abstractservice.service;

import com.abstractservice.IntegrationTest;
import com.abstractservice.entity.Member;
import com.abstractservice.service.onpremise.HyundaiMemberService;
import com.abstractservice.service.onpremise.SamsungMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.abstractservice.ClassInfoUtil.*;
import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("cloud")
class DefaultMemberServiceTest extends IntegrationTest {

  @Autowired
  DelegatingMemberService memberService;

  @Autowired
  ApplicationContext applicationContext;

  @Test
  void checkClassInfo() {
    checkIfProxy(memberService.getMemberService());
    printBeanName(applicationContext, memberService.getMemberService());
  }

  @Test
  void findByIdTest() {
    //given
    Member saved = memberService.save("기본");

    //when
    Member byId = memberService.findById(saved.getId());

    //then
    assertThat(saved.getName()).isEqualTo(byId.getName());
  }

  @Test
  void findAllTest() {
    //given
    Member saved = memberService.save("기본");
    Member saved2 = memberService.save("기본2");

    //when
    List<Member> all = memberService.findAll();

    //then
    assertThat(all).contains(saved, saved2);
  }

  @Test
  void beanCheck() {
    DelegatingMemberService delegatingMemberService = applicationContext.getBean("delegatingMemberService", DelegatingMemberService.class);
    DefaultMemberService defaultMemberService = applicationContext.getBean("memberService", DefaultMemberService.class);
    String[] memberServiceBeanNames = applicationContext.getBeanNamesForType(MemberService.class);

    assertThat(delegatingMemberService).isNotNull();
    assertThat(defaultMemberService).isNotNull();
    assertThat(defaultMemberService).isNotInstanceOf(SamsungMemberService.class);
    assertThat(defaultMemberService).isNotInstanceOf(HyundaiMemberService.class);
    assertThat(memberServiceBeanNames).containsOnly("delegatingMemberService", "memberService");

    assertThatThrownBy(() -> applicationContext.getBean("hyundaiMemberService", HyundaiMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
    assertThatThrownBy(() -> applicationContext.getBean("samsungMemberService", SamsungMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
  }
}
