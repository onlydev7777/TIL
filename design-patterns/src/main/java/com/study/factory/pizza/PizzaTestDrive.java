package com.study.factory.pizza;

import com.study.factory.pizza.chicago.ChicagoPizzaStore;
import com.study.factory.pizza.newyork.NYPizzaStore;

public class PizzaTestDrive {

  public static void main(String[] args) {
    PizzaStore nyPizzaStore = new NYPizzaStore();
    Pizza nyCheesePizza = nyPizzaStore.orderPizza("cheese");
    System.out.println("nyCheesePizza = " + nyCheesePizza.name);

    PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
    Pizza chicagoCheesePizza = chicagoPizzaStore.orderPizza("cheese");
    System.out.println("chicagoCheesePizza = " + chicagoCheesePizza.name);
  }
}
