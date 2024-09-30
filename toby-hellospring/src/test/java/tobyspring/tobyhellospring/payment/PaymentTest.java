package tobyspring.tobyhellospring.payment;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentTest {

  Clock clock;
  ExRateProviderStub exRateProviderStub;

  @BeforeEach
  void init() {
    this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    this.exRateProviderStub = new ExRateProviderStub(BigDecimal.valueOf(500));
  }

  @Test
  void createdPrepared() throws IOException {
    //given
    Payment payment = Payment.createPrepared(1L, "USD", BigDecimal.TEN, this.exRateProviderStub, LocalDateTime.now(this.clock));

    //when
    assertThat(payment.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(500));
    assertThat(payment.getValidUntil()).isEqualTo(LocalDateTime.now(clock).plusMinutes(30));
  }

  @Test
  void isValid() throws IOException {
    //given
    Payment payment = Payment.createPrepared(1L, "USD", BigDecimal.TEN, this.exRateProviderStub, LocalDateTime.now(this.clock));

    assertThat(payment.isValid(clock)).isTrue();
    assertThat(payment.isValid(Clock.offset(clock, Duration.of(30, ChronoUnit.MINUTES)))).isFalse();
  }

}