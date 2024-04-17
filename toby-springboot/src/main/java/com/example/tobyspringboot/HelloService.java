package com.example.tobyspringboot;

public interface HelloService {

  String sayHello(String name);

  default int countByName(String name) {
    return 0;
  }
}
