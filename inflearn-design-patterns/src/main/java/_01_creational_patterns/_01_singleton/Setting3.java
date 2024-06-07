package _01_creational_patterns._01_singleton;

/**
 * double checked locking
 */
public class Setting3 {

  private static volatile Setting3 setting3;

  private Setting3() {

  }

  public static Setting3 getInstance() {
    if (setting3 == null) {
      synchronized (Setting3.class) {
        if (setting3 == null) {
          setting3 = new Setting3();
        }
      }
    }
    return setting3;
  }
}
