package com.example.tobyspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class HelloServiceTest {

  @Test
  void simpleHelloService() {
    //given
    HelloService helloService = new SimpleHelloService(helloRepositoryStub);

    //when
    String res = helloService.sayHello("Spring");

    //then
    assertThat(res).isEqualTo("Hello Spring");
  }

  private static final HelloRepository helloRepositoryStub = new HelloRepository() {
    @Override
    public Hello findByName(String name) {
      return null;
    }

    @Override
    public void increaseCount(String name) {

    }
  };


  @Test
  void decoratorTest() {
    //given
    HelloDecorator helloDecorator = new HelloDecorator(new SimpleHelloService(helloRepositoryStub));

    String res = helloDecorator.sayHello("Spring");

    assertThat(res).isEqualTo("*Hello Spring*");

    //when

    //then

  }
}
