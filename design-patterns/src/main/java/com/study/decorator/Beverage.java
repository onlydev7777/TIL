package com.study.decorator;

public abstract class Beverage {

  protected String description = "제목없음";
  protected BeverageSize size;

  public Beverage(BeverageSize size) {
    this.size = size;
  }

  public Beverage() {
    this.size = BeverageSize.TALL;
  }

  public abstract double cost();

  public String getDescription() {
    return description;
  }

  public BeverageSize getSize() {
    return size;
  }

  protected enum BeverageSize {
    TALL, GRANDE, VENTI
  }
}
