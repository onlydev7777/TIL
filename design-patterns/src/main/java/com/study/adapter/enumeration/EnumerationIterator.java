package com.study.adapter.enumeration;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator {

  private final Enumeration enumeration;

  public EnumerationIterator(Enumeration enumeration) {
    this.enumeration = enumeration;
  }

  @Override
  public boolean hasNext() {
    return enumeration.hasMoreElements();
  }

  @Override
  public Object next() {
    return enumeration.nextElement();
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
