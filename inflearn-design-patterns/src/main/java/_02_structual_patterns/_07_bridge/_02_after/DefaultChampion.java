package _02_structual_patterns._07_bridge._02_after;

import _02_structual_patterns._07_bridge._01_before.Champion;

public class DefaultChampion implements Champion {

  private final Skin skin;
  private final String name;

  public DefaultChampion(Skin skin, String name) {
    this.skin = skin;
    this.name = name;
  }

  @Override
  public void move() {
    System.out.printf("%s %s move\n", skin.getName(), name);
  }

  @Override
  public void skillQ() {
    System.out.printf("%s %s Q\n", skin.getName(), name);
  }

  @Override
  public void skillW() {
    System.out.printf("%s %s W\n", skin.getName(), name);
  }

  @Override
  public void skillE() {
    System.out.printf("%s %s E\n", skin.getName(), name);
  }

  @Override
  public void skillR() {
    System.out.printf("%s %s R\n", skin.getName(), name);
  }

  @Override
  public String getName() {
    return null;
  }
}
