package collection.map.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryTest {

  public static void main(String[] args) {
    Map<String, String> dic = new HashMap<>();
    System.out.println("==단어 입력 단계==");
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.print("영어 단어를 입력하세요 (종료는 'q'): ");
      String input = sc.nextLine();
      if ("q".equals(input)) {
        break;
      }
      System.out.print("한글 뜻을 입력하세요: ");
      dic.put(input, sc.nextLine());
    }

    while (true) {
      System.out.print("찾을 영어 단어를 입력하세요 (종료는 'q'): ");
      String input = sc.nextLine();
      if ("q".equals(input)) {
        break;
      }
      if (dic.containsKey(input)) {
        System.out.println(input + "의 뜻 : " + dic.get(input));
      } else {
        System.out.println(input + "은(는) 사전에 없는 단어입니다.");
      }
    }
  }
}
