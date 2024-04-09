package com.study.factory.pizza;

import com.study.factory.pizza.ingredient.cheese.Cheese;
import com.study.factory.pizza.ingredient.clams.Clams;
import com.study.factory.pizza.ingredient.dough.Dough;
import com.study.factory.pizza.ingredient.pepperoni.Pepperoni;
import com.study.factory.pizza.ingredient.sauce.Sauce;
import com.study.factory.pizza.ingredient.veggies.Veggies;
import java.util.Arrays;

public abstract class Pizza {

  protected String name;
  protected Dough dough;
  protected Sauce sauce;
  protected Veggies[] veggies;
  protected Cheese cheese;
  protected Pepperoni pepperoni;
  protected Clams clam;

  public abstract void prepare();

  public void setName(String name) {
    this.name = name;
  }

  public void bake() {
    System.out.println("Pizza.bake");
  }

  public void cut() {
    System.out.println("Pizza.cut");
  }

  public void box() {
    System.out.println("Pizza.box");
  }

  @Override
  public String toString() {
    return "Pizza{" +
        "name='" + name + '\'' +
        ", dough=" + dough +
        ", sauce=" + sauce +
        ", veggies=" + Arrays.toString(veggies) +
        ", cheese=" + cheese +
        ", pepperoni=" + pepperoni +
        ", clam=" + clam +
        '}';
  }
}
