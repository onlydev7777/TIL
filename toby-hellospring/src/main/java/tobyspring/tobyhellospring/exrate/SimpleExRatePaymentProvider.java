package tobyspring.tobyhellospring.exrate;

import java.math.BigDecimal;
import tobyspring.tobyhellospring.payment.ExRateProvider;

public class SimpleExRatePaymentProvider implements ExRateProvider {

  public BigDecimal getExRate(String currency) {
    if ("USD".equals(currency)) {
      return BigDecimal.valueOf(1000);
    }
    throw new IllegalArgumentException("지원하지 않는 통화 양식 입니다.");
  }
}
