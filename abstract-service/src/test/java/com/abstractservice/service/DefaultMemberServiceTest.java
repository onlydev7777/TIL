package com.abstractservice.service;

import static com.abstractservice.service.ClassInfoUtil.checkIfProxy;
import static com.abstractservice.service.ClassInfoUtil.printBeanName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.abstractservice.entity.Member;
import com.abstractservice.service.onpremise.HyundaiMemberService;
import com.abstractservice.service.onpremise.SamsungMemberService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("default")
class DefaultMemberServiceTest extends IntegrationTest {

  @Autowired
  MemberServiceImpl memberService;

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
    MemberServiceImpl memberServiceImpl = applicationContext.getBean("memberServiceImpl", MemberServiceImpl.class);
    DefaultMemberService defaultMemberService = applicationContext.getBean("defaultMemberService", DefaultMemberService.class);
    String[] memberServiceBeanNames = applicationContext.getBeanNamesForType(MemberService.class);

    assertThat(memberServiceImpl).isNotNull();
    assertThat(defaultMemberService).isNotNull();
    assertThat(memberServiceBeanNames).containsOnly("memberServiceImpl", "defaultMemberService");

    assertThatThrownBy(() -> applicationContext.getBean("hyundaiMemberService", HyundaiMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
    assertThatThrownBy(() -> applicationContext.getBean("samsungMemberService", SamsungMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
  }
}
