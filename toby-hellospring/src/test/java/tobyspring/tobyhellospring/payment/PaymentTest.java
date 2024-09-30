package tobyspring.tobyhellospring.payment;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;

class PaymentTest {

  @Test
  void createdPrepared() {
    //given
    Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    Payment payment = Payment.createPrepared(1L, "USD", BigDecimal.TEN, BigDecimal.valueOf(1_000), LocalDateTime.now(clock));

    //when
    assertThat(payment.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(1_000));
    assertThat(payment.getValidUntil()).isEqualTo(LocalDateTime.now(clock).plusMinutes(30));
  }

  @Test
  void isValid() {
    //given
    Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    Payment payment = Payment.createPrepared(1L, "USD", BigDecimal.TEN, BigDecimal.valueOf(1_000), LocalDateTime.now(clock));

    assertThat(payment.isValid(clock)).isTrue();
    assertThat(payment.isValid(Clock.offset(clock, Duration.of(30, ChronoUnit.MINUTES)))).isFalse();
  }

}