package com.study.factory.pizza.newyork;

import com.study.factory.pizza.PizzaIngredientFactory;
import com.study.factory.pizza.ingredient.cheese.Cheese;
import com.study.factory.pizza.ingredient.clams.Clams;
import com.study.factory.pizza.ingredient.dough.Dough;
import com.study.factory.pizza.ingredient.clams.FreshClams;
import com.study.factory.pizza.ingredient.veggies.Garlic;
import com.study.factory.pizza.ingredient.sauce.MarinaraSauce;
import com.study.factory.pizza.ingredient.veggies.Mushroom;
import com.study.factory.pizza.ingredient.veggies.Onion;
import com.study.factory.pizza.ingredient.pepperoni.Pepperoni;
import com.study.factory.pizza.ingredient.veggies.RedPepper;
import com.study.factory.pizza.ingredient.cheese.ReggianoCheese;
import com.study.factory.pizza.ingredient.sauce.Sauce;
import com.study.factory.pizza.ingredient.pepperoni.SlicedPepperoni;
import com.study.factory.pizza.ingredient.dough.ThickCrustDough;
import com.study.factory.pizza.ingredient.veggies.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

  @Override
  public Dough createDough() {
    return new ThickCrustDough();
  }

  @Override
  public Sauce createSauce() {
    return new MarinaraSauce();
  }

  @Override
  public Cheese createCheese() {
    return new ReggianoCheese();
  }

  @Override
  public Veggies[] createVeggies() {
    return new Veggies[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
  }

  @Override
  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  @Override
  public Clams createClam() {
    return new FreshClams();
  }
}
