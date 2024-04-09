package com.study.factory.pizza.chicago;

import com.study.factory.pizza.PizzaIngredientFactory;
import com.study.factory.pizza.ingredient.veggies.BlackOlives;
import com.study.factory.pizza.ingredient.cheese.Cheese;
import com.study.factory.pizza.ingredient.clams.Clams;
import com.study.factory.pizza.ingredient.dough.Dough;
import com.study.factory.pizza.ingredient.veggies.Eggplant;
import com.study.factory.pizza.ingredient.clams.FrozenClams;
import com.study.factory.pizza.ingredient.cheese.MozzarellaCheese;
import com.study.factory.pizza.ingredient.pepperoni.Pepperoni;
import com.study.factory.pizza.ingredient.sauce.PlumTomatoSauce;
import com.study.factory.pizza.ingredient.sauce.Sauce;
import com.study.factory.pizza.ingredient.pepperoni.SlicedPepperoni;
import com.study.factory.pizza.ingredient.veggies.Spinach;
import com.study.factory.pizza.ingredient.dough.ThickCrustDough;
import com.study.factory.pizza.ingredient.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

  @Override
  public Dough createDough() {
    return new ThickCrustDough();
  }

  @Override
  public Sauce createSauce() {
    return new PlumTomatoSauce();
  }

  @Override
  public Cheese createCheese() {
    return new MozzarellaCheese();
  }

  @Override
  public Veggies[] createVeggies() {
    return new Veggies[]{new BlackOlives(), new Spinach(), new Eggplant()};
  }

  @Override
  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  @Override
  public Clams createClam() {
    return new FrozenClams();
  }
}
