package com.study.command.simpleremote.command;

import com.study.command.simpleremote.Command;
import com.study.command.simpleremote.receiver.GarageDoor;

public class GarageDoorOpenCommand implements Command {

  private GarageDoor garrageDoor;

  public GarageDoorOpenCommand(GarageDoor garrageDoor) {
    this.garrageDoor = garrageDoor;
  }

  @Override
  public void execute() {
    garrageDoor.up();
  }
}
