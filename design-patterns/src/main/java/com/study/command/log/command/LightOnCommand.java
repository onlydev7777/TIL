package com.study.command.log.command;

import com.study.command.log.Command;
import com.study.command.log.receiver.Light;

public class LightOnCommand implements Command {

  private Light light;

  public LightOnCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.on();
  }
}
