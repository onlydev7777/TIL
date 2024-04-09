package com.study.factory.pizza.newyork;

import com.study.factory.pizza.CalmPizza;
import com.study.factory.pizza.CheesePizza;
import com.study.factory.pizza.PepperoniPizza;
import com.study.factory.pizza.Pizza;
import com.study.factory.pizza.PizzaIngredientFactory;
import com.study.factory.pizza.PizzaStore;
import com.study.factory.pizza.VeggiePizza;

public class NYPizzaStore extends PizzaStore {

  @Override
  protected Pizza createPizza(String type) {
    Pizza pizza = null;
    PizzaIngredientFactory nyPizzaIngredientFactory = new NYPizzaIngredientFactory();
    if ("cheese".equals(type)) {
      pizza = new CheesePizza(nyPizzaIngredientFactory);
      pizza.setName("NY cheese pizza");
    } else if ("pepperoni".equals(type)) {
      pizza = new PepperoniPizza(nyPizzaIngredientFactory);
      pizza.setName("NY pepperoni pizza");
    } else if ("clam".equals(type)) {
      pizza = new CalmPizza(nyPizzaIngredientFactory);
      pizza.setName("NY clam pizza");
    } else if ("veggie".equals(type)) {
      pizza = new VeggiePizza(nyPizzaIngredientFactory);
      pizza.setName("NY veggie pizza");
    }

    return pizza;
  }
}
