package tobyspring.tobyhellospring.payment;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobyspring.tobyhellospring.TestPaymentConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
class PaymentSpringServiceTest {

  @Autowired
  private PaymentService paymentService;
  @Autowired
  private ExRateProviderStub exRateProviderStub;
  @Autowired
  private Clock clock;

  @Test
  void prepare() throws IOException {
    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    assertThat(payment.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(500));
    assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(5_000));

    exRateProviderStub.setExRate(BigDecimal.valueOf(1_000));

    Payment payment2 = paymentService.prepare(1L, "USD", BigDecimal.TEN);
    assertThat(payment2.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(1_000));
    assertThat(payment2.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(10_000));
  }

  @Test
  void validUntil() throws IOException {
    PaymentService paymentService = new PaymentService(new ExRateProviderStub(BigDecimal.valueOf(500)), this.clock);
    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    assertThat(payment.getValidUntil()).isEqualTo(LocalDateTime.now(this.clock).plusMinutes(30));
  }
}
