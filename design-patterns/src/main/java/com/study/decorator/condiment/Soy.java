package com.study.decorator.condiment;

import com.study.decorator.Beverage;
import com.study.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {

  private Beverage beverage;

  public Soy(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double cost() {
    double costBySize = .15;
    if (beverage.getSize() == BeverageSize.GRANDE) {
      costBySize = .20;
    }
    if (beverage.getSize() == BeverageSize.VENTI) {
      costBySize = .25;
    }

    return beverage.cost() + costBySize;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", 두유";
  }
}
