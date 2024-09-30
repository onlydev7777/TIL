package tobyspring.tobyhellospring.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Table(name = "orders")
@Entity
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String no;
  private BigDecimal total;

  protected Order() {
  }

  public Order(String no, BigDecimal total) {
    this.no = no;
    this.total = total;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", no='" + no + '\'' +
        ", total=" + total +
        '}';
  }
}
