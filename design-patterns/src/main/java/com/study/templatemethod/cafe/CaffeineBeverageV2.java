package com.study.templatemethod.cafe;

public abstract class CaffeineBeverageV2 {

  final void prepareRecipe() {    // 서브 클래스 에서 재정의 할 수 없도록 final 키워드 넣기.
    boilWater();
    brew();
    pourInCup();
    addCondiments();
  }

  void boilWater() {
    System.out.println("CaffeineBeverage.boilWater");
  }

  void pourInCup() {
    System.out.println("CaffeineBeverage.pourInCup");
  }

  abstract void brew();             // 커피 or 티 를 우려낸다.

  abstract void addCondiments();    // 첨가물을 넣는다.
}
