package com.study.strategy;

import com.study.strategy.behavior.FlyRocketPowred;

public class MiniDuckSimulator {

  public static void main(String[] args) {
    Duck modelDuck = new ModelDuck();
    modelDuck.performFly();
    modelDuck.performQuack();

    modelDuck.setFlyBehavior(new FlyRocketPowred());
    modelDuck.performFly();
  }
}
