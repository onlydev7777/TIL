package com.study.strategy.behavior;

public class Quack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("Quack.quack");
  }
}
