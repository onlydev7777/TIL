package com.study.command.simpleremote.command;

import com.study.command.simpleremote.Command;
import com.study.command.simpleremote.receiver.GarageDoor;

public class GarageDoorDownCommand implements Command {

  private GarageDoor garrageDoor;

  public GarageDoorDownCommand(GarageDoor garrageDoor) {
    this.garrageDoor = garrageDoor;
  }

  @Override
  public void execute() {
    garrageDoor.down();
  }

  @Override
  public void undo() {
    garrageDoor.up();
  }
}
