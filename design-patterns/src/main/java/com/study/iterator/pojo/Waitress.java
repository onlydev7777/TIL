package com.study.iterator.pojo;

import java.util.Iterator;
import java.util.List;

public class Waitress {

  List<Menu> menus;

  public Waitress(List<Menu> menus) {
    this.menus = menus;
  }

  public void printMenu() {
    for (Menu menu : menus) {
      printMenu(menu.createIterator());
    }
  }

  private void printMenu(Iterator<MenuItem> iterator) {
    while (iterator.hasNext()) {
      MenuItem menuItem = iterator.next();
      System.out.print(menuItem.getName() + ", ");
      System.out.print(menuItem.getPrice() + " -- ");
      System.out.println(menuItem.getDescription());
    }
  }

  public void printVegetarianMenu() {
    System.out.println("\nVEGETARIAN MENU\n---------------");
    for (Menu menu : menus) {
      printVegetarianMenu(menu.createIterator());
    }
  }

  public boolean isItemVegetarian(String name) {
    for (Menu menu : menus) {
      if (isVegetarian(name, menu.createIterator())) {
        return true;
      }
    }
    return false;
  }


  private void printVegetarianMenu(Iterator<MenuItem> iterator) {
    while (iterator.hasNext()) {
      MenuItem menuItem = iterator.next();
      if (menuItem.isVegetarian()) {
        System.out.print(menuItem.getName() + ", ");
        System.out.print(menuItem.getPrice() + " -- ");
        System.out.println(menuItem.getDescription());
      }
    }
  }

  private boolean isVegetarian(String name, Iterator<MenuItem> iterator) {
    while (iterator.hasNext()) {
      MenuItem menuItem = iterator.next();
      if (menuItem.getName().equals(name)) {
        if (menuItem.isVegetarian()) {
          return true;
        }
      }
    }
    return false;
  }
}

