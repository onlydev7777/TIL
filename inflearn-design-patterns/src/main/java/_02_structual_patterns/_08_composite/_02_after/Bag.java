package _02_structual_patterns._08_composite._02_after;

import java.util.ArrayList;
import java.util.List;

public class Bag implements Component {

  private List<Component> components = new ArrayList<>();

  public void add(Item item) {
    components.add(item);
  }

  public List<Component> getComponents() {
    return components;
  }

  @Override
  public int getPrice() {
    return this.components.stream()
        .mapToInt(c -> c.getPrice())
        .sum();
  }
}
