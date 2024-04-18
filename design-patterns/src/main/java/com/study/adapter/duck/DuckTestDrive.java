package com.study.adapter.duck;

public class DuckTestDrive {

  public static void main(String[] args) {
    Duck mallardDuck = new MallardDuck();
    testDuck(mallardDuck);

    Turkey wildTurkey = new WildTurkey();
    wildTurkey.gobble();
    wildTurkey.fly();

    System.out.println("=============================");

    TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);
    testDuck(turkeyAdapter);
  }

  private static void testDuck(Duck duck) {
    duck.quack();
    duck.fly();
  }

}
