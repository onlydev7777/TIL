package com.study.command;

public class GarageDoorOpenCommand implements Command {

  private GarageDoor garrageDoor;

  public GarageDoorOpenCommand(GarageDoor garrageDoor) {
    this.garrageDoor = garrageDoor;
  }

  @Override
  public void execute() {
    garrageDoor.open();
  }
}
