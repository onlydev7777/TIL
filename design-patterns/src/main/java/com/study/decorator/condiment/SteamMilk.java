package com.study.decorator.condiment;

import com.study.decorator.Beverage;
import com.study.decorator.CondimentDecorator;

public class SteamMilk extends CondimentDecorator {

  private Beverage beverage;

  public SteamMilk(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double cost() {
    double costBySize = .10;
    if (beverage.getSize() == BeverageSize.GRANDE) {
      costBySize = .15;
    }
    if (beverage.getSize() == BeverageSize.VENTI) {
      costBySize = .20;
    }

    return beverage.cost() + costBySize;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", 스팀우유";
  }
}
