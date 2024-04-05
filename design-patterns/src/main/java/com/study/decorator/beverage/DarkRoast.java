package com.study.decorator.beverage;

import com.study.decorator.Beverage;

public class DarkRoast extends Beverage {

  public DarkRoast() {
    super();
    this.description = "다크로스트";
  }

  public DarkRoast(BeverageSize size) {
    super(size);
    this.description = "다크로스트";
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
