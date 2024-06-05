package _03_abstract_factory._03_java;

import _02_factory_method._01_before.Ship;
import _02_factory_method._02_after.WhiteShip;
import org.springframework.beans.factory.FactoryBean;

public class ShipFactory implements FactoryBean<Ship> {

  @Override
  public Ship getObject() throws Exception {
    Ship ship = new WhiteShip();
    ship.setName("whiteship");
    return ship;
  }

  @Override
  public Class<?> getObjectType() {
    return Ship.class;
  }
}
