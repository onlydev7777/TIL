package tobyspring.tobyhellospring.payment;

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

  public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) {
    return Payment.createPrepared(orderId, currency, foreignCurrencyAmount, exRateProvider, LocalDateTime.now(this.clock));
  }
}
