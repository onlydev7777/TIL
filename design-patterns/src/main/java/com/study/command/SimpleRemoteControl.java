package com.study.command;

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
