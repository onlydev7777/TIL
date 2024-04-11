package com.study.singleton;

public class LazyHolderSingleton {

  private LazyHolderSingleton() {

  }

  public static LazyHolderSingleton getInstance() {
    return InnerClass.instance;
  }

  private static class InnerClass {

    private static final LazyHolderSingleton instance = new LazyHolderSingleton();
  }
}
