package com.study.observer.subject;

import com.study.observer.observer.Observer;

public interface Subject {

  void registerObserver(Observer o);

  void removeObserver(Observer o);

  void notifyObservers();
}
