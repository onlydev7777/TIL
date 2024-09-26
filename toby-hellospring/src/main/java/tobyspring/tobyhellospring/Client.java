package tobyspring.tobyhellospring;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobyspring.tobyhellospring.payment.Payment;
import tobyspring.tobyhellospring.payment.PaymentService;

public class Client {

  public static void main(String[] args) throws IOException, InterruptedException {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
    PaymentService paymentService = beanFactory.getBean(PaymentService.class);
    Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
    System.out.println("payment = " + payment);

    TimeUnit.SECONDS.sleep(1);

    System.out.println("====================================================");
    Payment payment2 = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
    System.out.println("payment2 = " + payment2);

    TimeUnit.SECONDS.sleep(2);

    System.out.println("====================================================");
    Payment payment3 = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
    System.out.println("payment3 = " + payment3);
  }
}
