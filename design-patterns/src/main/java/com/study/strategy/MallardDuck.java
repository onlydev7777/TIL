package com.study.strategy;

import com.study.strategy.behavior.FlyWithWings;
import com.study.strategy.behavior.Quack;

public class MallardDuck extends Duck {

  public MallardDuck() {
    this.quackBehavior = new Quack();
    this.flyBehavior = new FlyWithWings();
  }

  @Override
  public void display() {
    System.out.println("MallardDuck.display");
  }
}
