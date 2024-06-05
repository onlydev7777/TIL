package _01_singleton;

/**
 * static inner 클래스 홀더
 */
public class Setting4 {

  private Setting4() {

  }

  private static class SettingHolder {

    private static final Setting4 INSTANCE = new Setting4();
  }

  public static Setting4 getInstance() {
    return SettingHolder.INSTANCE;
  }
}
