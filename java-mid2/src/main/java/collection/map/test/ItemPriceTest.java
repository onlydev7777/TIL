package collection.map.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemPriceTest {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("사과", 500);
    map.put("바나나", 500);
    map.put("망고", 1000);
    map.put("딸기", 1000);

    List<String> findKey = map.entrySet().stream()
        .filter(entry -> entry.getValue() == 1000)
        .map(entry -> entry.getKey())
        .toList();

    System.out.println("findKey = " + findKey);
  }
}
