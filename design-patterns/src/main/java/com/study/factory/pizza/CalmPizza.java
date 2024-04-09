package com.study.factory.pizza;

public class CalmPizza extends Pizza {

  private PizzaIngredientFactory pizzaIngredientFactory;

  public CalmPizza(PizzaIngredientFactory pizzaIngredientFactory) {
    this.pizzaIngredientFactory = pizzaIngredientFactory;
  }

  @Override
  public void prepare() {
    System.out.println("CalmPizza.prepare");

    dough = pizzaIngredientFactory.createDough();
    sauce = pizzaIngredientFactory.createSauce();
    cheese = pizzaIngredientFactory.createCheese();
    clam = pizzaIngredientFactory.createClam();
  }
}
