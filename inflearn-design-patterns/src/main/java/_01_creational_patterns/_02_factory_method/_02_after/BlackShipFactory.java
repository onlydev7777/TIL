package _01_creational_patterns._02_factory_method._02_after;

import _01_creational_patterns._02_factory_method._01_before.Ship;

public class BlackShipFactory implements ShipFactory {

  @Override
  public Ship createShip(String name) {
    BlackShip blackShip = new BlackShip();
    blackShip.setName(name);
    blackShip.setLogo("⚓");
    blackShip.setColor("black");
    return blackShip;
  }
}
