package tobyspring.tobyhellospring;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import tobyspring.tobyhellospring.api.ApiTemplate;
import tobyspring.tobyhellospring.api.ErApiExRateExtractor;
import tobyspring.tobyhellospring.api.SimpleApiExecutor;
import tobyspring.tobyhellospring.exrate.RestTemplateExRateProvider;
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
    return new RestTemplateExRateProvider(restTemplate());
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public Clock clock() {
    return Clock.systemDefaultZone();
  }

  @Bean
  public ApiTemplate apiTemplate() {
    return new ApiTemplate(new SimpleApiExecutor(), new ErApiExRateExtractor());
  }
}
