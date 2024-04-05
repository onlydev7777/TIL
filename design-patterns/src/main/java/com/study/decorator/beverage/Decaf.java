package com.study.decorator.beverage;

import com.study.decorator.Beverage;

public class Decaf extends Beverage {

  public Decaf() {
    super();
    this.description = "디카페인";
  }

  public Decaf(BeverageSize size) {
    super(size);
    this.description = "디카페인";
  }

  @Override
  public double cost() {
    double cost = 1.05;
    if (getSize() == BeverageSize.GRANDE) {
      cost += 0.5;
    }
    if (getSize() == BeverageSize.VENTI) {
      cost += 1.0;
    }
    return cost;
  }
}
