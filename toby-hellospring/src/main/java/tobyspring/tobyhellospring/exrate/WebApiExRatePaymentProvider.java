package tobyspring.tobyhellospring.exrate;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import tobyspring.tobyhellospring.api.ApiTemplate;
import tobyspring.tobyhellospring.payment.ExRateProvider;

@Component
public class WebApiExRatePaymentProvider implements ExRateProvider {

  private final ApiTemplate apiTemplate;

  public WebApiExRatePaymentProvider(ApiTemplate apiTemplate) {
    this.apiTemplate = apiTemplate;
  }

  @Override
  public BigDecimal getExRate(String currency) {
    String url = "https://open.er-api.com/v6/latest/" + currency;

    return apiTemplate.getExRate(url);
  }
}
