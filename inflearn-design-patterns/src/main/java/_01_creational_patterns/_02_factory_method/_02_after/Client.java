package _01_creational_patterns._02_factory_method._02_after;

import _01_creational_patterns._02_factory_method._01_before.Ship;

public class Client {

  public static void main(String[] args) {
    printShip(new BlackShipFactory(), "blackship", "ykj@mail.com");
    printShip(new WhiteShipFactory(), "whiteship", "ykj@mail.com");
  }

  private static void printShip(ShipFactory shipFactory, String name, String email) {
    Ship ship = shipFactory.orderShip(name, email);
    System.out.println("ship = " + ship);
  }
}
