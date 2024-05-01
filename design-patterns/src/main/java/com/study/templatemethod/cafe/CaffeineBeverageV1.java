package com.study.templatemethod.cafe;

public abstract class CaffeineBeverageV1 {

  abstract void prepareRecipe();

  void boilWater() {
    System.out.println("CaffeineBeverage.boilWater");
  }

  void pourInCup() {
    System.out.println("CaffeineBeverage.pourInCup");
  }
}
