package com.study.command.simpleremote.invoker;

import com.study.command.simpleremote.Command;
import com.study.command.simpleremote.receiver.NoCommand;

public class RemoteControlWithUndo {

  private static final int REMOTE_BUTTON_COUNT = 7;
  private Command[] onCommands;
  private Command[] offCommands;
  private Command undoCommand;

  public RemoteControlWithUndo() {
    onCommands = new Command[REMOTE_BUTTON_COUNT];
    offCommands = new Command[REMOTE_BUTTON_COUNT];

    Command noCommand = new NoCommand();
    for (int slot = 0; slot < REMOTE_BUTTON_COUNT; slot++) {
      onCommands[slot] = noCommand;
      offCommands[slot] = noCommand;
    }
    undoCommand = noCommand;
  }

  public void setCommands(int slot, Command onCommand, Command offCommand) {
    setOnCommands(slot, onCommand);
    setOffCommands(slot, offCommand);
  }

  public void setOnCommands(int slot, Command onCommand) {
    onCommands[slot] = onCommand;
  }

  public void setOffCommands(int slot, Command offCommand) {
    offCommands[slot] = offCommand;
  }

  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
    undoCommand = onCommands[slot];
  }

  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
    undoCommand = offCommands[slot];
  }

  public void undoButtonWasPushed() {
    undoCommand.undo();
  }

  @Override
  public String toString() {
    StringBuffer stringBuff = new StringBuffer();
    stringBuff.append("\n------ Remote Control -------\n");
    for (int i = 0; i < onCommands.length; i++) {
      stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
          + "    " + offCommands[i].getClass().getName() + "\n");
    }
    return stringBuff.toString();
  }
}
