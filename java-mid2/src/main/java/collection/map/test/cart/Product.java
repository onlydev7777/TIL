package collection.map.test.cart;

import java.util.Objects;

public class Product {

  private String name;
  private Integer price;

  public Product(String name, Integer price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Product product = (Product) object;
    return Objects.equals(name, product.name) && Objects.equals(price, product.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price);
  }

  @Override
  public String toString() {
    return "Product{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
