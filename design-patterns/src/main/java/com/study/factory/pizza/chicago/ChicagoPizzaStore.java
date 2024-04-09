package com.study.factory.pizza.chicago;

import com.study.factory.pizza.CalmPizza;
import com.study.factory.pizza.CheesePizza;
import com.study.factory.pizza.PepperoniPizza;
import com.study.factory.pizza.Pizza;
import com.study.factory.pizza.PizzaIngredientFactory;
import com.study.factory.pizza.PizzaStore;
import com.study.factory.pizza.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

  @Override
  protected Pizza createPizza(String type) {
    Pizza pizza = null;
    PizzaIngredientFactory chicagoPizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
    if ("cheese".equals(type)) {
      pizza = new CheesePizza(chicagoPizzaIngredientFactory);
      pizza.setName("chicago cheese pizza");
    } else if ("pepperoni".equals(type)) {
      pizza = new PepperoniPizza(chicagoPizzaIngredientFactory);
      pizza.setName("chicago pepperoni pizza");
    } else if ("clam".equals(type)) {
      pizza = new CalmPizza(chicagoPizzaIngredientFactory);
      pizza.setName("chicago clam pizza");
    } else if ("veggie".equals(type)) {
      pizza = new VeggiePizza(chicagoPizzaIngredientFactory);
      pizza.setName("chicago veggie pizza");
    }
    
    return pizza;
  }
}
