package com.study.strategy;

import com.study.strategy.behavior.FlyNoWay;
import com.study.strategy.behavior.Quack;

public class ModelDuck extends Duck {

  public ModelDuck() {
    this.flyBehavior = new FlyNoWay();
    this.quackBehavior = new Quack();
  }

  @Override
  public void display() {
    System.out.println("ModelDuck.display");
  }
}
