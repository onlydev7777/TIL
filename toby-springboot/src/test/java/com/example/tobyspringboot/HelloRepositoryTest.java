package com.example.tobyspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HellobootTest
public class HelloRepositoryTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private HelloRepository helloRepository;

  @Test
  void findHelloFailed() {
    assertThat(helloRepository.findByName("Toby")).isNull();
  }

  @Test
  void increaseCount() {
    assertThat(helloRepository.countByName("Toby")).isEqualTo(0);

    helloRepository.increaseCount("Toby");
    assertThat(helloRepository.countByName("Toby")).isEqualTo(1);

    helloRepository.increaseCount("Toby");
    assertThat(helloRepository.countByName("Toby")).isEqualTo(2);
  }
}
