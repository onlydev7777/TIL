package com.example.tobyspringboot;

public interface HelloRepository {

  Hello findByName(String name);

  void increaseCount(String name);

  default int countByName(String name) {
    Hello hello = findByName(name);
    return hello == null ? 0 : hello.getCount();
  }
}
