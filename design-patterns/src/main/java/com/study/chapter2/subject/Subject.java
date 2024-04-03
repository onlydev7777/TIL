package com.study.chapter2.subject;

import com.study.chapter2.observer.Observer;

public interface Subject {

  void registerObserver(Observer o);

  void removeObserver(Observer o);

  void notifyObservers();
}
