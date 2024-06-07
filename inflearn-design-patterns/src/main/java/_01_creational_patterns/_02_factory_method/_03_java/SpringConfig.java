package _01_creational_patterns._02_factory_method._03_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  @Bean
  public String hello() {
    return "hello";
  }
}
