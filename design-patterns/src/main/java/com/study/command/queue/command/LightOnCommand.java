package com.study.command.queue.command;

import com.study.command.queue.Command;
import com.study.command.queue.receiver.Light;

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
