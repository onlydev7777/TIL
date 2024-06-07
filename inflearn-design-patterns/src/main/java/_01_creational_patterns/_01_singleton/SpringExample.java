package _01_creational_patterns._01_singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExample {

  public static void main(String[] args) {
    //스프링 싱글톤 스코프 방식
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
    String hello = applicationContext.getBean("hello", String.class);
    String hello2 = applicationContext.getBean("hello", String.class);
    System.out.println(hello == hello2);
  }
}
