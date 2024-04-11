package com.study.singleton;

public class LegacySingleton {

  private static LegacySingleton instance;

  private LegacySingleton() {

  }

  public static LegacySingleton getInstance() {
    if (instance == null) {
      return new LegacySingleton();
    }
    return instance;
  }
}
