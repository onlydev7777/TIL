package com.study.adapter.enumeration;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EnumerationIteratorTest {

  public static void main(String[] args) {
    Vector<String> vector = new Vector<>();
    vector.add("hi");
    vector.add("adapter patterns~");

    Enumeration<String> enumeration = vector.elements();

    Iterator enumerationIterator = new EnumerationIterator(enumeration);

    while (enumerationIterator.hasNext()) {
      System.out.println("enumerationIterator.next() = " + enumerationIterator.next());
    }
  }

}
