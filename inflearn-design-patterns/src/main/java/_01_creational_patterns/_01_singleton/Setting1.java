package _01_creational_patterns._01_singleton;

/**
 * private 생성자와 public static 메소드를 사용하는 방법
 */
public class Setting1 {

  private static Setting1 setting1;

  private Setting1() {
  }

  public static Setting1 getInstance() {
    if (setting1 == null) {
      setting1 = new Setting1();
    }
    return setting1;
  }
}
