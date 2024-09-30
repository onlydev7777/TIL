package tobyspring.tobyhellospring;

import java.io.IOException;
import java.math.BigDecimal;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobyspring.tobyhellospring.payment.Payment;
import tobyspring.tobyhellospring.payment.PaymentService;

public class Client {

  public static void main(String[] args) throws IOException {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(PaymentConfig.class);
    PaymentService paymentService = beanFactory.getBean(PaymentService.class);
    Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
    System.out.println("payment = " + payment);
  }
}
