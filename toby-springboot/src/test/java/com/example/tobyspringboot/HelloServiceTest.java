package com.example.tobyspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class HelloServiceTest {

  @Test
  void simpleHelloService() {
    //given
    HelloService helloService = new SimpleHelloService();

    //when
    String res = helloService.sayHello("Spring");

    //then
    assertThat(res).isEqualTo("Hello Spring");
  }

  @Test
  void decoratorTest() {
    //given
    HelloDecorator helloDecorator = new HelloDecorator(new SimpleHelloService());

    String res = helloDecorator.sayHello("Spring");

    assertThat(res).isEqualTo("*Hello Spring*");

    //when

    //then

  }
}
