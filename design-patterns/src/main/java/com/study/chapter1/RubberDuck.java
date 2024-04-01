package com.study.chapter1;

public class RubberDuck extends Duck implements Quackable {

  @Override
  public void display() {
    System.out.println("RubberDuck.display");
  }

  @Override
  public void quack() {
    System.out.println("RubberDuck.quack");
  }
}
