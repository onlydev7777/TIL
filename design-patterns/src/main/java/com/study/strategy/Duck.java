package com.study.strategy;

import com.study.strategy.behavior.FlyBehavior;
import com.study.strategy.behavior.QuackBehavior;

public abstract class Duck {

  protected FlyBehavior flyBehavior;
  protected QuackBehavior quackBehavior;

  public void swim() {
    System.out.println("Duck.swim");
  }

  public void display() {
    System.out.println("Duck.display");
  }

  public void performFly() {
    flyBehavior.fly();
  }

  public void performQuack() {
    quackBehavior.quack();
  }
  //기타 오리 메서드


  public void setFlyBehavior(FlyBehavior flyBehavior) {
    this.flyBehavior = flyBehavior;
  }

  public void setQuackBehavior(QuackBehavior quackBehavior) {
    this.quackBehavior = quackBehavior;
  }
}
