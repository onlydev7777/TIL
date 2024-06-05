package _03_abstract_factory._02_after;

public class WhiteshipPartsProFactory implements ShipPartsFactory {

  @Override
  public Anchor createAnchor() {
    return new WhiteAnchorPro();
  }

  @Override
  public Wheel createWheel() {
    return new WhiteWheelPro();
  }
}
