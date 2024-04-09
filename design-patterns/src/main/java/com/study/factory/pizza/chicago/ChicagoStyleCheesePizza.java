package com.study.factory.pizza.chicago;

import com.study.factory.pizza.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {

  public ChicagoStyleCheesePizza() {
    this.name = "Chicago Style Deep Dish Cheese Pizza";
    this.dough = "Extra Thick Crust Dough";
    this.sauce = "Plum Tomato Sauce";

    this.toppings.add("Shredded Mozzarella Cheese");
  }

  @Override
  public void cut() {
    System.out.println("ChicagoStyleCheesePizza.cut");
  }
}
