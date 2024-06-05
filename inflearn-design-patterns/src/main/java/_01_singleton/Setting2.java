package _01_singleton;

/**
 * synchronized 사용해서 동기화 처리
 */
public class Setting2 {

  private static Setting2 setting2;

  private Setting2() {

  }

  public static synchronized Setting2 getInstance() {
    if (setting2 == null) {
      setting2 = new Setting2();
    }
    return setting2;
  }
}
