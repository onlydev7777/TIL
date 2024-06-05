package _02_factory_method._02_after;

import _02_factory_method._01_before.Ship;

public interface ShipFactory {

  default Ship orderShip(String name, String email) {
    prepareFor(name);
    Ship ship = createShip(name);
    sendEmailTo(email, ship);

    return ship;
  }


  Ship createShip(String name);

  private void prepareFor(String name) {
    System.out.println(name + " 만들 준비 중");
  }

  private void sendEmailTo(String email, Ship ship) {
    System.out.println(ship.getName() + " 다 만들었습니다.");
  }
}
