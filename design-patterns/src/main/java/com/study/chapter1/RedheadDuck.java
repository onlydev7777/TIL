package com.study.chapter1;

public class RedheadDuck extends Duck implements Flyable, Quackable {

  @Override
  public void display() {
    System.out.println("RedheadDuck.display");
  }

  @Override
  public void fly() {
    System.out.println("RedheadDuck.fly");
  }

  @Override
  public void quack() {
    System.out.println("RedheadDuck.quack");
  }
}
