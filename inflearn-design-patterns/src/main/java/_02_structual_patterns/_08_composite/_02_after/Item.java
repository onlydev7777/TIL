package _02_structual_patterns._08_composite._02_after;

public class Item implements Component {

  private String name;

  private int price;

  public Item(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public int getPrice() {
    return this.price;
  }
}
