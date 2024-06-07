package _01_creational_patterns._03_abstract_factory._02_after;

import _01_creational_patterns._02_factory_method._01_before.Ship;
import _01_creational_patterns._02_factory_method._02_after.ShipFactory;

public class Client {

  public static void main(String[] args) {
    //구체적인 클래스에 의존해서 생성하지 않고, 추상화된 인터페이스로 생성, concrete product 를 감출 수 있다.
    ShipFactory shipFactory = new WhiteshipFactory(new WhiteshipPartsFactory());
    ShipFactory shipFactory2 = new WhiteshipFactory(new WhiteshipPartsProFactory());
    Ship whiteship = shipFactory.createShip("whiteship");
    Ship whiteship_pro = shipFactory2.createShip("whiteship-pro");
    System.out.println(whiteship.getAnchor().getClass());
    System.out.println(whiteship.getWheel().getClass());
    System.out.println(whiteship_pro.getAnchor().getClass());
    System.out.println(whiteship_pro.getWheel().getClass());
  }
}
