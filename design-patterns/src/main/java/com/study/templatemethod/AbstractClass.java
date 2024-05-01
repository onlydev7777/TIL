package com.study.templatemethod;

public abstract class AbstractClass {

  final void templateMethod() {
    primitiveOperation1();
    primitiveOperation2();
    concreteOperation1();
    concreteOperation2();
    hook();
  }


  abstract void primitiveOperation1();

  abstract void primitiveOperation2();

  final void concreteOperation1() {    // 재정의 불가한 구상 메서드
    System.out.println("AbstractClass.concreteOperation");
  }

  void concreteOperation2() {   // 재정의 가능한 구상 메서드
    System.out.println("AbstractClass.concreteOperation2");
  }

  void hook() {     // 아무것도 하지 않는 메서드, 서브 클래스에서 정의해도 되고 하지 않아도 됨
  }
}
