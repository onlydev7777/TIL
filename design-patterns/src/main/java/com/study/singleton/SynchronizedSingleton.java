package com.study.singleton;

public class SynchronizedSingleton {

  private static SynchronizedSingleton instance;

  private SynchronizedSingleton() {

  }

  public static synchronized SynchronizedSingleton getInstance() {
    if (instance == null) {
      return new SynchronizedSingleton();
    }
    return instance;
  }
}
