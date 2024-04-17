package com.example.tobyspringboot;

import com.example.config.MySpringBootApplication;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@MySpringBootApplication
public class TobySpringbootApplication {

  private final JdbcTemplate jdbcTemplate;

  public TobySpringbootApplication(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @PostConstruct
  void init() {
    jdbcTemplate.execute(
        "create table if not exists hello(name varchar(50) primary key, count int)");
  }

  public static void main(String[] args) {
    SpringApplication.run(TobySpringbootApplication.class, args);
  }
}
