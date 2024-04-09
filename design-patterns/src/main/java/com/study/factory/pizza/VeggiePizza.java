package com.study.factory.pizza;

public class VeggiePizza extends Pizza {

  private PizzaIngredientFactory pizzaIngredientFactory;

  public VeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
    this.pizzaIngredientFactory = pizzaIngredientFactory;
  }

  @Override
  public void prepare() {
    System.out.println("VeggiePizza.prepare");

    dough = pizzaIngredientFactory.createDough();
    sauce = pizzaIngredientFactory.createSauce();
    cheese = pizzaIngredientFactory.createCheese();
    veggies = pizzaIngredientFactory.createVeggies();
  }
}
