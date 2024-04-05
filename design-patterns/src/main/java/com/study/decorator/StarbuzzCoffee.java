package com.study.decorator;

import com.study.decorator.Beverage.BeverageSize;
import com.study.decorator.beverage.DarkRoast;
import com.study.decorator.beverage.Espresso;
import com.study.decorator.beverage.HouseBlend;
import com.study.decorator.condiment.Mocha;
import com.study.decorator.condiment.Soy;
import com.study.decorator.condiment.Whip;

public class StarbuzzCoffee {

  public static void main(String[] args) {
    //espresso 주문
    Espresso espressoVenti = new Espresso(BeverageSize.VENTI);
    System.out.println("espressoVenti.getDescription() = " + espressoVenti.getDescription());
    System.out.println("espressoVenti.cost() = " + espressoVenti.cost());

    //dark roast(TALL)에 모카+휘핑크림 주문
    Beverage darkRoast = new DarkRoast();
    darkRoast = new Mocha(darkRoast);
    darkRoast = new Whip(darkRoast);
    System.out.println("darkRoast.getDescription() = " + darkRoast.getDescription());
    System.out.println("darkRoast.cost() = " + darkRoast.cost());

    //dark roast(VENTI)에 모카+휘핑크림 주문
    Beverage darkRoastVenti = new DarkRoast(BeverageSize.VENTI);
    darkRoastVenti = new Mocha(darkRoastVenti);
    darkRoastVenti = new Whip(darkRoastVenti);
    System.out.println("darkRoastVenti.getDescription() = " + darkRoastVenti.getDescription());
    System.out.println("darkRoastVenti.cost() = " + darkRoastVenti.cost());

    //houst blend 두유+모카+휘핑크림 주문
    Beverage houseBlend = new HouseBlend();
    houseBlend = new Soy(houseBlend);
    houseBlend = new Mocha(houseBlend);
    houseBlend = new Whip(houseBlend);
    System.out.println("houseBlend.getDescription() = " + houseBlend.getDescription());
    System.out.println("houseBlend.cost() = " + houseBlend.cost());
  }

}
