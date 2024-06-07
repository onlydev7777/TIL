package _01_creational_patterns._02_factory_method._02_after;

import _01_creational_patterns._02_factory_method._01_before.Ship;

public class WhiteShipFactory implements ShipFactory {

  @Override
  public Ship createShip(String name) {
    WhiteShip whiteShip = new WhiteShip();
    whiteShip.setName(name);
    whiteShip.setLogo("\uD83D\uDEE5️");
    whiteShip.setColor("white");
    return whiteShip;
  }
}
