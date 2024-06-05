package _03_abstract_factory._03_java;

import _02_factory_method._01_before.Ship;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanExample {

  public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
//        Ship whiteship = applicationContext.getBean("whiteship", Ship.class);
//        System.out.println(whiteship.getName());

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
    Ship bean = applicationContext.getBean(Ship.class);
    System.out.println(bean);
  }
}
