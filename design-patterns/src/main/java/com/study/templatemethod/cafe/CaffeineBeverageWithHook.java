package com.study.templatemethod.cafe;

public abstract class CaffeineBeverageWithHook {

  final void prepareRecipe() {    // 서브 클래스 에서 재정의 할 수 없도록 final 키워드 넣기.
    boilWater();
    brew();
    pourInCup();
    if (customerWantsCondiments()) {
      addCondiments();
    }
  }

  boolean customerWantsCondiments() {   // default는 true 이지만 서브클래스가 재정의하기에 따라서 첨가물이 들어갈지 말지가 결정됨
    return true;
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
