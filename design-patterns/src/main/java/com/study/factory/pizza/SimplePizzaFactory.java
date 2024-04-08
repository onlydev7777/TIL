package com.study.factory.pizza;

public class SimplePizzaFactory {

  public Pizza createPizza(String type) {
    if ("cheese".equals(type)) {
      return new CheesePizza();
    } else if ("pepperoni".equals(type)) {
      return new PepperoniPizza();
    } else if ("clam".equals(type)) {
      return new ClamPizza();
    } else if ("eggie".equals(type)) {
      return new EggiePizza();
    }

    return null;
  }
}
