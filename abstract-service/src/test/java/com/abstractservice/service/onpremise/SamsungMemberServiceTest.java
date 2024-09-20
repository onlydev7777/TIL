package com.abstractservice.service.onpremise;

import static com.abstractservice.service.ClassInfoUtil.checkIfProxy;
import static com.abstractservice.service.ClassInfoUtil.printBeanName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.abstractservice.entity.Member;
import com.abstractservice.service.DefaultMemberService;
import com.abstractservice.service.DelegatingMemberService;
import com.abstractservice.service.IntegrationTest;
import com.abstractservice.service.MemberService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("samsung")
class SamsungMemberServiceTest extends IntegrationTest {

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
    Member saved = memberService.save("삼성");

    //when
    Member byId = memberService.findById(saved.getId());

    //then
    assertThat(saved.getName()).isEqualTo(byId.getName());
  }

  @Test
  void findAllTest() {
    //given
    Member saved = memberService.save("삼성");
    Member saved2 = memberService.save("삼성2");

    //when
    List<Member> all = memberService.findAll();

    //then
    assertThat(all).contains(saved, saved2);
  }

  @Test
  void beanCheck() {
    DelegatingMemberService delegatingMemberService = applicationContext.getBean("delegatingMemberService", DelegatingMemberService.class);
    SamsungMemberService samsungMemberService = applicationContext.getBean("samsungMemberService", SamsungMemberService.class);
    DefaultMemberService defaultMemberService = applicationContext.getBean(DefaultMemberService.class);
    String[] memberServiceBeanNames = applicationContext.getBeanNamesForType(MemberService.class);

    assertThat(delegatingMemberService).isNotNull();
    assertThat(samsungMemberService).isNotNull();
    assertThat(defaultMemberService).isInstanceOf(SamsungMemberService.class);
    assertThat(defaultMemberService).isNotInstanceOf(HyundaiMemberService.class);
    assertThat(memberServiceBeanNames).containsOnly("delegatingMemberService", "samsungMemberService");

    assertThatThrownBy(() -> applicationContext.getBean("defaultMemberService", DefaultMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
    assertThatThrownBy(() -> applicationContext.getBean("hyundaiMemberService", HyundaiMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
  }
}
