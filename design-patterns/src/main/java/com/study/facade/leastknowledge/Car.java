package com.study.facade.leastknowledge;

public class Car {

  Engine engine;

  public void start(Key key) {
    Doors doors = new Doors();
    
    boolean authorized = key.turns();   // 파라미터로 전달된 객체 메서드

    if (authorized) {
      engine.start();                   // 객체에 속하는 구성요소 메서드
      updateDashboardDisplay();         // 객체 자체 메서드
      doors.lock();                     // 메서드에서 생성한 객체
    }
  }

  private void updateDashboardDisplay() {

  }

  static class Engine {

    public void start() {

    }
  }

  static class Key {

    public boolean turns() {
      return false;
    }
  }

  static class Doors {

    public void lock() {

    }
  }
}
