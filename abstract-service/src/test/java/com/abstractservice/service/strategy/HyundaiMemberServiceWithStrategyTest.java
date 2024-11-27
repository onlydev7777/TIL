package com.abstractservice.service.strategy;

import com.abstractservice.IntegrationTest;
import com.abstractservice.entity.Member;
import com.abstractservice.service.DefaultMemberService;
import com.abstractservice.service.DelegatingMemberService;
import com.abstractservice.service.MemberService;
import com.abstractservice.service.onpremise.HyundaiMemberService;
import com.abstractservice.service.onpremise.SamsungMemberService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.abstractservice.ClassInfoUtil.*;
import static org.assertj.core.api.Assertions.*;


@Disabled
@ActiveProfiles("hyundai")
class HyundaiMemberServiceWithStrategyTest extends IntegrationTest {

  @Autowired
  DelegatingMemberService service;

  @Autowired
  ApplicationContext applicationContext;

  @Test
  void checkClassInfo() {
    checkIfProxy(service.getMemberService());
    printBeanName(applicationContext, service.getMemberService());
  }

  @Test
  void findByIdTest() {
    //given
    Member saved = service.save("현대");

    //when
    Member byId = service.findById(saved.getId());

    //then
    assertThat(saved.getName()).isEqualTo(byId.getName());
  }

  @Test
  void findAllTest() {
    //given
    Member saved = service.save("현대");
    Member saved2 = service.save("현대2");

    //when
    List<Member> all = service.findAll();

    //then
    assertThat(all).contains(saved, saved2);
  }

  @Test
  void beanCheck() {
    DelegatingMemberService delegatingMemberService = applicationContext.getBean("delegatingMemberService", DelegatingMemberService.class);
    DefaultMemberService defaultMemberService = applicationContext.getBean("hyundaiMemberService", HyundaiMemberService.class);
    String[] memberServiceBeanNames = applicationContext.getBeanNamesForType(MemberService.class);

    MemberStrategy memberStrategy = applicationContext.getBean(MemberStrategy.class);
    HyundaiMemberStrategy hyundaiMemberStrategy = applicationContext.getBean("hyundaiMemberStrategy", HyundaiMemberStrategy.class);

    assertThat(delegatingMemberService).isNotNull();
    assertThat(defaultMemberService).isNotNull();
    assertThat(memberStrategy).isNotNull();
    assertThat(hyundaiMemberStrategy).isNotNull();
    assertThat(hyundaiMemberStrategy).isInstanceOf(HyundaiMemberStrategy.class);
    assertThat(memberStrategy).isInstanceOf(HyundaiMemberStrategy.class);
    assertThat(defaultMemberService).isNotInstanceOf(SamsungMemberService.class);
    assertThat(defaultMemberService).isNotInstanceOf(DelegatingMemberService.class);
    assertThat(memberStrategy).isNotInstanceOf(DefaultMemberStrategy.class);
    assertThat(memberStrategy).isNotInstanceOf(SamsungMemberStrategy.class);
    assertThat(memberServiceBeanNames).containsOnly("delegatingMemberService", "hyundaiMemberService");

    assertThatThrownBy(() -> applicationContext.getBean("defaultMemberService", DefaultMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
    assertThatThrownBy(() -> applicationContext.getBean("samsungMemberService", SamsungMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
  }
}