package com.study.command.simpleremote.receiver;

import com.study.command.simpleremote.Command;

public class NoCommand implements Command {

  @Override
  public void execute() {
    System.out.println("NoCommand.execute");
  }

  @Override
  public void undo() {
    System.out.println("NoCommand.undo");
  }
}
