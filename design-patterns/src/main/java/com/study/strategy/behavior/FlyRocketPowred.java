package com.study.strategy.behavior;

public class FlyRocketPowred implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("FlyRocketPowred.fly");
  }
}
