package com.study.templatemethod.cafe;

public class Coffee extends CaffeineBeverageV2 {
  
  @Override
  void brew() {
    System.out.println("Coffee.brew");
  }

  @Override
  void addCondiments() {
    System.out.println("Coffee.addCondiments");
  }
}
