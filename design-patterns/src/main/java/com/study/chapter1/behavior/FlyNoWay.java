package com.study.chapter1.behavior;

public class FlyNoWay implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("FlyNoWay.fly");
  }
}
