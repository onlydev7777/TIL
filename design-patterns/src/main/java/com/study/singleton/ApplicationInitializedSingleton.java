package com.study.singleton;

public class ApplicationInitializedSingleton {

  private static ApplicationInitializedSingleton instance = new ApplicationInitializedSingleton();

  private ApplicationInitializedSingleton() {

  }

  public static ApplicationInitializedSingleton getInstance() {
    return instance;
  }
}
