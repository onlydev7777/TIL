package com.study.chapter1;

import com.study.chapter1.behavior.FlyWithWings;
import com.study.chapter1.behavior.Quack;

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
