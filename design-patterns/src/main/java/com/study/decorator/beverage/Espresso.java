package com.study.decorator.beverage;

import com.study.decorator.Beverage;

public class Espresso extends Beverage {

  public Espresso() {
    super();
    this.description = "에스프레소";
  }

  public Espresso(BeverageSize size) {
    super(size);
    this.description = "에스프레소";
  }

  @Override
  public double cost() {
    double cost = 1.99;
    if (getSize() == BeverageSize.GRANDE) {
      cost += 0.5;
    }
    if (getSize() == BeverageSize.VENTI) {
      cost += 1.0;
    }
    return cost;
  }
}
