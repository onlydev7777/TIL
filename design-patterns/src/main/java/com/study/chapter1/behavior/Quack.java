package com.study.chapter1.behavior;

public class Quack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("Quack.quack");
  }
}
