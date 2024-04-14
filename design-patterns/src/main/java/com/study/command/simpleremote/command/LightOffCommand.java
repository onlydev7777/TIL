package com.study.command.simpleremote.command;

import com.study.command.simpleremote.Command;
import com.study.command.simpleremote.receiver.Light;

public class LightOffCommand implements Command {

  private Light light;

  public LightOffCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.off();
  }

  @Override
  public void undo() {
    light.on();
  }
}
