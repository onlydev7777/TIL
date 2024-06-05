package _03_abstract_factory._02_after;

import _02_factory_method._01_before.Ship;
import _02_factory_method._02_after.ShipFactory;
import _02_factory_method._02_after.WhiteShip;

public class WhiteshipFactory implements ShipFactory {

  private final ShipPartsFactory shipPartsFactory;

  public WhiteshipFactory(ShipPartsFactory shipPartsFactory) {
    this.shipPartsFactory = shipPartsFactory;
  }

  @Override
  public Ship createShip(String name) {
    WhiteShip whiteShip = new WhiteShip();
    whiteShip.setName(name);
    whiteShip.setLogo("\uD83D\uDEE5️");
    whiteShip.setColor("white");
    whiteShip.setAnchor(shipPartsFactory.createAnchor());
    whiteShip.setWheel(shipPartsFactory.createWheel());
    return whiteShip;
  }
}
