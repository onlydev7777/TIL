package com.study.chapter1;

import com.study.chapter1.behavior.FlyRocketPowred;

public class MiniDuckSimulator {

  public static void main(String[] args) {
    Duck modelDuck = new ModelDuck();
    modelDuck.performFly();
    modelDuck.performQuack();

    modelDuck.setFlyBehavior(new FlyRocketPowred());
    modelDuck.performFly();
  }
}
