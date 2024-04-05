package com.study.decorator.condiment;

import com.study.decorator.Beverage;
import com.study.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {

  private Beverage beverage;

  public Mocha(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double cost() {
    double costBySize = .20;
    if (beverage.getSize() == BeverageSize.GRANDE) {
      costBySize = .25;
    }
    if (beverage.getSize() == BeverageSize.VENTI) {
      costBySize = .30;
    }

    return beverage.cost() + costBySize;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", 모카";
  }
}
