package com.abstractservice.service;

import com.abstractservice.service.onpremise.HyundaiMemberService;
import com.abstractservice.service.onpremise.SamsungMemberService;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;

public class ClassInfoUtil {

  public static void checkIfProxy(MemberService service) {
    if (AopUtils.isAopProxy(service)) {
      System.out.println(service + " is a proxy.");
      if (AopUtils.isCglibProxy(service)) {
        System.out.println(service + " is a CGLIB proxy.");
      } else if (AopUtils.isJdkDynamicProxy(service)) {
        System.out.println(service + " is a JDK Dynamic proxy.");
      }
    } else {
      System.out.println(service + " is not a proxy.");
    }
  }

  public static void printBeanName(ApplicationContext applicationContext, MemberService memberService) {
    String[] beanNames = applicationContext.getBeanNamesForType(memberService.getClass());
    System.out.println(memberService.getClass() + " beanNames = " + beanNames[0]);
    System.out.println("================================= printAllBeanNames");
    printAllBeanNames(applicationContext);
  }

  private static void printAllBeanNames(ApplicationContext applicationContext) {
    String[] memberServiceBeanNames = applicationContext.getBeanNamesForType(MemberService.class);
    String[] memberServiceImplBeanNames = applicationContext.getBeanNamesForType(MemberServiceImpl.class);
    String[] defaultMemberServiceBeanNames = applicationContext.getBeanNamesForType(DefaultMemberService.class);
    String[] samsungMemberServiceBeanNames = applicationContext.getBeanNamesForType(SamsungMemberService.class);
    String[] hyundaiMemberServiceBeanNames = applicationContext.getBeanNamesForType(HyundaiMemberService.class);

    beanNamesPrint(memberServiceBeanNames, "MemberService");
    beanNamesPrint(memberServiceImplBeanNames, "MemberServiceImpl");
    beanNamesPrint(defaultMemberServiceBeanNames, "DefaultMemberService");
    beanNamesPrint(samsungMemberServiceBeanNames, "SamsungMemberService");
    beanNamesPrint(hyundaiMemberServiceBeanNames, "HyundaiMemberService");
  }

  private static void beanNamesPrint(String[] beanNames, String className) {
    for (String beanName : beanNames) {
      System.out.println(className + "  beanName = " + beanName);
    }
  }
}
