package com.study.command.simpleremote.invoker;

import com.study.command.simpleremote.Command;

public class SimpleRemoteControl {

  private Command slot;

  public SimpleRemoteControl(Command slot) {
    this.slot = slot;
  }

  public void buttonWasPressed() {
    slot.execute();
  }

  public void changeSlot(Command slot) {
    this.slot = slot;
  }
}
