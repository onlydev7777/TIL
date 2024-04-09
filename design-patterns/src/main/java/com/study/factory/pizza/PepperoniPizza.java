package com.study.factory.pizza;

public class PepperoniPizza extends Pizza {

  private PizzaIngredientFactory pizzaIngredientFactory;

  public PepperoniPizza(PizzaIngredientFactory pizzaIngredientFactory) {
    this.pizzaIngredientFactory = pizzaIngredientFactory;
  }

  @Override
  public void prepare() {
    System.out.println("PepperoniPizza.prepare");

    dough = pizzaIngredientFactory.createDough();
    sauce = pizzaIngredientFactory.createSauce();
    cheese = pizzaIngredientFactory.createCheese();
    veggies = pizzaIngredientFactory.createVeggies();
    pepperoni = pizzaIngredientFactory.createPepperoni();
  }
}
