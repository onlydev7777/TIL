package com.study.factory.pizza.newyork;

import com.study.factory.pizza.Pizza;
import com.study.factory.pizza.PizzaStore;

public class NYPizzaStore extends PizzaStore {

  @Override
  protected Pizza createPizza(String type) {
    if ("cheese".equals(type)) {
      return new NYStyleCheesePizza();
    } else if ("pepperoni".equals(type)) {
      return new NYStylePepperoniPizza();
    } else if ("clam".equals(type)) {
      return new NYStyleClamPizza();
    } else if ("eggie".equals(type)) {
      return new NYStyleEggiePizza();
    }
    return null;
  }
}
