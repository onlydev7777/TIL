package tobyspring.tobyhellospring;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

  public static void main(String[] args) {
    List<String> scores = Arrays.asList("z", "x", "spring", "java");
    Collections.sort(scores, Comparator.comparingInt(String::length));

    scores.forEach(System.out::println);
  }
}
