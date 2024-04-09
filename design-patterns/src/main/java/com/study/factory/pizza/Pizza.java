package com.study.factory.pizza;

import java.util.ArrayList;

public abstract class Pizza {

  protected String name;
  protected String dough;
  protected String sauce;
  protected ArrayList<String> toppings = new ArrayList<>();

  public void prepare() {
    System.out.println("name = " + name);
    System.out.println("dough = " + dough);
    System.out.println("sauce = " + sauce);
    for (String topping : toppings) {
      System.out.println("topping = " + topping);
    }
    System.out.println("Pizza.prepare");
  }

  public void bake() {
    System.out.println("Pizza.bake");
  }

  public void cut() {
    System.out.println("Pizza.cut");
  }

  public void box() {
    System.out.println("Pizza.box");
  }
}
