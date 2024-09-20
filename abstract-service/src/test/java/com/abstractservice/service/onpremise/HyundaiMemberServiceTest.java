package com.abstractservice.service.onpremise;

import static com.abstractservice.service.ClassInfoUtil.checkIfProxy;
import static com.abstractservice.service.ClassInfoUtil.printBeanName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.abstractservice.entity.Member;
import com.abstractservice.service.DefaultMemberService;
import com.abstractservice.service.IntegrationTest;
import com.abstractservice.service.MemberService;
import com.abstractservice.service.MemberServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("hyundai")
class HyundaiMemberServiceTest extends IntegrationTest {

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
    MemberServiceImpl memberServiceImpl = applicationContext.getBean("memberServiceImpl", MemberServiceImpl.class);
    HyundaiMemberService hyundaiMemberService = applicationContext.getBean("hyundaiMemberService", HyundaiMemberService.class);
    String[] memberServiceBeanNames = applicationContext.getBeanNamesForType(MemberService.class);

    assertThat(memberServiceImpl).isNotNull();
    assertThat(hyundaiMemberService).isNotNull();
    assertThat(memberServiceBeanNames).containsOnly("memberServiceImpl", "hyundaiMemberService");

    assertThatThrownBy(() -> applicationContext.getBean("defaultMemberService", DefaultMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
    assertThatThrownBy(() -> applicationContext.getBean("samsungMemberService", SamsungMemberService.class))
        .isInstanceOf(NoSuchBeanDefinitionException.class);
  }
}