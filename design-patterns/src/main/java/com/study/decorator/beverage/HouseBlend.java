package com.study.decorator.beverage;

import com.study.decorator.Beverage;

public class HouseBlend extends Beverage {

  public HouseBlend() {
    super();
    this.description = "하우스 블렌드 커피";
  }

  public HouseBlend(BeverageSize size) {
    super(size);
    this.description = "하우스 블렌드 커피";
  }

  @Override
  public double cost() {
    double cost = .89;
    if (getSize() == BeverageSize.GRANDE) {
      cost += 0.5;
    }
    if (getSize() == BeverageSize.VENTI) {
      cost += 1.0;
    }
    return cost;
  }
}
