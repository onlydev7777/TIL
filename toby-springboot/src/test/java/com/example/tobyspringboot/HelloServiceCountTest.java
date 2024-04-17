package com.example.tobyspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@HellobootTest
public class HelloServiceCountTest {

  @Autowired
  private HelloService helloService;

  @Test
  void sayHelloIncreaseCount() {
    IntStream.rangeClosed(1, 10).forEach(count -> {
      helloService.sayHello("Toby");
      assertThat(helloService.countByName("Toby")).isEqualTo(count);
    });
  }
}
