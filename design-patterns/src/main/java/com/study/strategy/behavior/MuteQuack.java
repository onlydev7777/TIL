package com.study.strategy.behavior;

public class MuteQuack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("MuteQuack.quack");
  }
}
