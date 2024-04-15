package com.study.command.queue.command;

import com.study.command.queue.Command;
import com.study.command.queue.receiver.Stereo;

public class StereoOnCommand implements Command {

  private Stereo stereo;

  public StereoOnCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.on();
  }
}
