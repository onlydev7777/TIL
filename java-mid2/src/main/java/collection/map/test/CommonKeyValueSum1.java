package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class CommonKeyValueSum1 {

  public static void main(String[] args) {
    Map<String, Integer> map1 = new HashMap<>();
    map1.put("A", 1);
    map1.put("B", 2);
    map1.put("C", 3);
    Map<String, Integer> map2 = new HashMap<>();
    map2.put("B", 4);
    map2.put("C", 5);
    map2.put("D", 6);

    Map<String, Integer> result = new HashMap<>();
    for (String map1Key : map1.keySet()) {
      if (map2.containsKey(map1Key)) {
        int sum = map1.get(map1Key) + map2.get(map1Key);
        result.put(map1Key, sum);
      }
    }

    System.out.println("result = " + result);
  }
}
