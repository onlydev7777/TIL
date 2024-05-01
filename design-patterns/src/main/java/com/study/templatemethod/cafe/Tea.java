package com.study.templatemethod.cafe;

public class Tea extends CaffeineBeverageV2 {

  @Override
  void brew() {
    System.out.println("Tea.brew");
  }

  @Override
  void addCondiments() {
    System.out.println("Tea.addCondiments");
  }
}
