package tobyspring.tobyhellospring.payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  private final ExRateProvider exRateProvider;
  private final Clock clock;

  public PaymentService(ExRateProvider exRateProvider, Clock clock) {
    this.exRateProvider = exRateProvider;
    this.clock = clock;
  }

  public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
    BigDecimal exRate = exRateProvider.getExRate(currency);
    
    return Payment.createPrepared(orderId, currency, foreignCurrencyAmount, exRate, LocalDateTime.now(this.clock));
  }
}
