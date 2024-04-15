package com.study.command.log.invoker;

import com.study.command.log.Command;
import java.util.ArrayList;
import java.util.List;

public class LogCommand {

  private Command command;
  private List<Command> logCommands;

  public LogCommand() {
    this.logCommands = new ArrayList<>();
  }

  public void setCommand(Command command) {
    this.command = command;
  }

  public void buttonOnPushed() {
    command.execute();
    logCommands.add(command);
  }

  public void historyPrint() {
    for (Command logCommand : logCommands) {
      String name = logCommand.getClass().getName();
      System.out.println("logCommand = " + logCommand);
    }
  }
}
