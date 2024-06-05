package _03_abstract_factory._01_before;

import _02_factory_method._01_before.Ship;
import _02_factory_method._02_after.ShipFactory;
import _02_factory_method._02_after.WhiteShip;

public class WhiteshipFactory implements ShipFactory {

  @Override
  public Ship createShip(String name) {
    Ship ship = new WhiteShip();
    ship.setAnchor(new WhiteAnchor());
    ship.setWheel(new WhiteWheel());
    return ship;
  }
}
