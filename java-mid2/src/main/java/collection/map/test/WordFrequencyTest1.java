package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest1 {

  public static void main(String[] args) {
    String text = "orange banana apple apple banana apple";

    String[] arr = text.split(" ");
    Map<String, Integer> result = new HashMap<>();

    for (String data : arr) {
      result.put(data, result.getOrDefault(data, 0) + 1);
    }

    System.out.println("result = " + result);
  }
}
