package com.study.factory;

import com.study.factory.pizza.Pizza;
import com.study.factory.pizza.SimplePizzaFactory;

public class PizzaStore {

  private SimplePizzaFactory pizzaFactory;

  public PizzaStore(SimplePizzaFactory pizzaFactory) {
    this.pizzaFactory = pizzaFactory;
  }

  public Pizza orderPizza(String type) {
    Pizza pizza = pizzaFactory.createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }
}
