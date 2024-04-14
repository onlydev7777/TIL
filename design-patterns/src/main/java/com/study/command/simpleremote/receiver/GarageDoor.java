package com.study.command.simpleremote.receiver;

public class GarageDoor {

  private String location;

  public GarageDoor(String location) {
    this.location = location;
  }

  public void up() {
    System.out.println(location + " GarrageDoor.up");
  }

  public void down() {
    System.out.println(location + " GarrageDoor.down");
  }
}
