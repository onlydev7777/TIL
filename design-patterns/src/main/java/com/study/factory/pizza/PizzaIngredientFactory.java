package com.study.factory.pizza;

import com.study.factory.pizza.ingredient.cheese.Cheese;
import com.study.factory.pizza.ingredient.clams.Clams;
import com.study.factory.pizza.ingredient.dough.Dough;
import com.study.factory.pizza.ingredient.pepperoni.Pepperoni;
import com.study.factory.pizza.ingredient.sauce.Sauce;
import com.study.factory.pizza.ingredient.veggies.Veggies;

public interface PizzaIngredientFactory {

  Dough createDough();

  Sauce createSauce();

  Cheese createCheese();

  Veggies[] createVeggies();

  Pepperoni createPepperoni();

  Clams createClam();
}
