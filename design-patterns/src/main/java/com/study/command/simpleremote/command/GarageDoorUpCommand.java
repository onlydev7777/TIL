package com.study.command.simpleremote.command;

import com.study.command.simpleremote.Command;
import com.study.command.simpleremote.receiver.GarageDoor;

public class GarageDoorUpCommand implements Command {

  private GarageDoor garrageDoor;

  public GarageDoorUpCommand(GarageDoor garrageDoor) {
    this.garrageDoor = garrageDoor;
  }

  @Override
  public void execute() {
    garrageDoor.up();
  }

  @Override
  public void undo() {
    garrageDoor.down();
  }
}
