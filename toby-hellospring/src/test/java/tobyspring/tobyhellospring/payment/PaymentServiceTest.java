package tobyspring.tobyhellospring.payment;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {

  Clock clock;

  @BeforeEach
  void init() {
    this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
  }

  @Test
  void prepare() throws IOException {

    testAmount(BigDecimal.valueOf(500), BigDecimal.valueOf(5000));
    testAmount(BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
    testAmount(BigDecimal.valueOf(300), BigDecimal.valueOf(3000));
  }

  @Test
  void validUntil() throws IOException {
    PaymentService paymentService = new PaymentService(new ExRateProviderStub(BigDecimal.valueOf(500)), this.clock);
    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    assertThat(payment.getValidUntil()).isEqualTo(LocalDateTime.now(this.clock).plusMinutes(30));
  }

  private void testAmount(BigDecimal exRate, BigDecimal convertedAmount) throws IOException {
    //given
    PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate), this.clock);
    //when
    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
    assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
  }
}
