package _01_creational_patterns._02_factory_method._03_java;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactoryExample {

  public static void main(String[] args) {
    //스프링 BeanFactory 인터페이스는 팩터리 메서드 패턴으로 구현 되어 있음. 내부는 너무 복잡함...
    BeanFactory xmlFactory = new ClassPathXmlApplicationContext("config.xml");
    String hello = xmlFactory.getBean("hello", String.class);
    System.out.println("hello = " + hello);

    BeanFactory javaFactory = new AnnotationConfigApplicationContext(SpringConfig.class);
    String hello2 = javaFactory.getBean("hello", String.class);
    System.out.println("hello2 = " + hello2);


  }
}
