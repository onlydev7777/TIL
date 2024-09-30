package tobyspring.tobyhellospring;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.tobyhellospring.exrate.WebApiExRatePaymentProvider;
import tobyspring.tobyhellospring.payment.ExRateProvider;
import tobyspring.tobyhellospring.payment.PaymentService;

@Configuration
public class PaymentConfig {

  @Bean
  public PaymentService paymentService() {
    return new PaymentService(exRateProvider(), clock());
  }

  @Bean
  public ExRateProvider exRateProvider() {
    return new WebApiExRatePaymentProvider();
  }

  @Bean
  public Clock clock() {
    return Clock.systemDefaultZone();
  }
}
