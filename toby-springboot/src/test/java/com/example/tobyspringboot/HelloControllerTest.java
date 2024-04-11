package com.example.tobyspringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

  @Test
  void helloController() {
    //given
    HelloController helloController = new HelloController(name -> name);
    //when
    String res = helloController.hello("Test");

    //then
    Assertions.assertThat(res).isEqualTo("Test");
  }

  @Test
  void failedHelloController() {
    //given
    HelloController helloController = new HelloController(name -> name);

    //when, then
    Assertions.assertThatThrownBy(
        () -> helloController.hello(null)
    ).isInstanceOf(IllegalArgumentException.class);

    Assertions.assertThatThrownBy(
        () -> helloController.hello("")
    ).isInstanceOf(IllegalArgumentException.class);
  }
}
