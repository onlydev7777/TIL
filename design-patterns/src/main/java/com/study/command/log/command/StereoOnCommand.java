package com.study.command.log.command;

import com.study.command.log.Command;
import com.study.command.log.receiver.Stereo;

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
