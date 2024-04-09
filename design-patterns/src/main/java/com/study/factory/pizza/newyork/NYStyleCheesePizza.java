package com.study.factory.pizza.newyork;

import com.study.factory.pizza.Pizza;

public class NYStyleCheesePizza extends Pizza {

  public NYStyleCheesePizza() {
    this.name = "NY Style Sauce and Cheese Pizza";
    this.dough = "Thin Crust Dough";
    this.sauce = "Marinara Sauce";
    
    this.toppings.add("Grated Reggiano Cheese");
  }

  @Override
  public void cut() {
    System.out.println("NYStyleCheesePizza.cut");
  }
}
