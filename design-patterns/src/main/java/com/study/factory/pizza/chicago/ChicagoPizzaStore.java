package com.study.factory.pizza.chicago;

import com.study.factory.pizza.Pizza;
import com.study.factory.pizza.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {

  @Override
  protected Pizza createPizza(String type) {
    if ("cheese".equals(type)) {
      return new ChicagoStyleCheesePizza();
    } else if ("pepperoni".equals(type)) {
      return new ChicagoStylePepperoniPizza();
    } else if ("clam".equals(type)) {
      return new ChicagoStyleClamPizza();
    } else if ("eggie".equals(type)) {
      return new ChicagoStyleEggiePizza();
    }
    return null;
  }
}
