package com.study.chapter1.behavior;

public class FlyWithWings implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("FlyWithWings.fly");
  }
}
