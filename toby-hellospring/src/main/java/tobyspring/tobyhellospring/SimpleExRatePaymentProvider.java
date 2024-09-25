package tobyspring.tobyhellospring;

import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExRatePaymentProvider {

  BigDecimal getExRate(String currency) throws IOException {
    if ("USD".equals(currency)) {
      return BigDecimal.valueOf(1000);
    }
    throw new IllegalArgumentException("지원하지 않는 통화 양식 입니다.");
  }
}
