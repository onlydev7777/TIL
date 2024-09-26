package tobyspring.tobyhellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.tobyhellospring.exrate.CachedExRateProvider;
import tobyspring.tobyhellospring.exrate.WebApiExRatePaymentProvider;
import tobyspring.tobyhellospring.payment.ExRateProvider;
import tobyspring.tobyhellospring.payment.PaymentService;

@Configuration
public class ObjectFactory {

  @Bean
  public PaymentService paymentService() {
    return new PaymentService(cachedExRateProvider());
  }

  @Bean
  public ExRateProvider exRateProvider() {
    return new WebApiExRatePaymentProvider();
  }

  @Bean
  public ExRateProvider cachedExRateProvider() {
    return new CachedExRateProvider(exRateProvider());
  }
}
