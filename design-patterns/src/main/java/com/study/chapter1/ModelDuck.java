package com.study.chapter1;

import com.study.chapter1.behavior.FlyNoWay;
import com.study.chapter1.behavior.Quack;

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
