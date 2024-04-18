package com.study.adapter.enumeration;

import java.util.ArrayList;
import java.util.Enumeration;

public class IteratorEnumerationTest {

  public static void main(String[] args) {
    ArrayList<String> iterator = new ArrayList<>();
    iterator.add("hi");
    iterator.add("hello");

    Enumeration iteratorEnumeration = new IteratorEnumeration(iterator.iterator());

    while (iteratorEnumeration.hasMoreElements()) {
      System.out.println(
          "iteratorEnumeration.nextElement() = " + iteratorEnumeration.nextElement());
    }
  }
}
