package com.study.adapter.enumeration;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorEnumeration implements Enumeration {

  private final Iterator iterator;

  public IteratorEnumeration(Iterator iterator) {
    this.iterator = iterator;
  }

  @Override
  public boolean hasMoreElements() {
    return iterator.hasNext();
  }

  @Override
  public Object nextElement() {
    Object result = iterator.next();
    iterator.remove();
    return result;
  }
}
