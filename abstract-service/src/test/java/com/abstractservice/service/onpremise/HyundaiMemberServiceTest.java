package com.abstractservice.service.onpremise;

import com.abstractservice.IntegrationTest;
import com.abstractservice.entity.Member;
import com.abstractservice.service.DefaultMemberService;
import com.abstractservice.service.DelegatingMemberService;
import com.abstractservice.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.abstractservice.ClassInfoUtil.*;
import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("hyundai")
class HyundaiMemberServiceTest extends IntegrationTest {

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
    Member saved = memberService.save("현대");

    //when
    Member byId = memberService.findById(saved.getId());

    //then
    assertThat(saved.getName()).isEqualTo(byId.getName());
  }

  @Test
  void findAllTest() {
    //given
    Member saved = memberService.save("현대");
    Member saved2 = memberService.save("현대2");

    //when
    List<Member> all = memberService.findAll();

    //then
    assertThat(all).contains(saved, saved2);
  }

  @Test
  void beanCheck() {
    DelegatingMemberService delegatingMemberService = applicationContext.getBean("delegatingMemberService", DelegatingMemberService.class);
    HyundaiMemberService hyundaiMemberService = applicationContext.getBean("memberService", HyundaiMemberService.class);
//    DefaultMemberService defaultMemberService = applicationContext.getBean(DefaultMemberService.class);
    String[] memberServiceBeanNames = applicationContext.getBeanNamesForType(MemberService.class);

    assertThat(delegatingMemberService).isNotNull();
    assertThat(hyundaiMemberService).isNotNull();
//    assertThat(defaultMemberService).isInstanceOf(HyundaiMemberService.class);
//    assertThat(defaultMemberService).isNotInstanceOf(SamsungMemberService.class);
    assertThat(memberServiceBeanNames).containsOnly("delegatingMemberService", "memberService");

    assertThatThrownBy(() -> applicationContext.getBean("defaultMemberService", DefaultMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
    assertThatThrownBy(() -> applicationContext.getBean("samsungMemberService", SamsungMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
  }
}