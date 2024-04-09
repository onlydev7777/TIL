package com.study.factory.pizza;

import com.study.factory.pizza.chicago.ChicagoStyleCheesePizza;
import com.study.factory.pizza.chicago.ChicagoStyleClamPizza;
import com.study.factory.pizza.chicago.ChicagoStyleEggiePizza;
import com.study.factory.pizza.chicago.ChicagoStylePepperoniPizza;
import com.study.factory.pizza.newyork.NYStyleCheesePizza;
import com.study.factory.pizza.newyork.NYStyleClamPizza;
import com.study.factory.pizza.newyork.NYStyleEggiePizza;
import com.study.factory.pizza.newyork.NYStylePepperoniPizza;

public class DependentPizzaStore {

  public Pizza createPizza(String style, String type) {
    Pizza pizza = null;

    if ("NY".equals(style)) {
      if ("cheese".equals(type)) {
        pizza = new NYStyleCheesePizza();
      } else if ("pepperoni".equals(type)) {
        pizza = new NYStylePepperoniPizza();
      } else if ("clam".equals(type)) {
        pizza = new NYStyleClamPizza();
      } else if ("eggie".equals(type)) {
        pizza = new NYStyleEggiePizza();
      }
    } else if ("Chicago".equals(style)) {
      if ("cheese".equals(type)) {
        pizza = new ChicagoStyleCheesePizza();
      } else if ("pepperoni".equals(type)) {
        pizza = new ChicagoStylePepperoniPizza();
      } else if ("clam".equals(type)) {
        pizza = new ChicagoStyleClamPizza();
      } else if ("eggie".equals(type)) {
        pizza = new ChicagoStyleEggiePizza();
      }
    }

    return pizza;
  }
}
