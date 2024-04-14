package com.study.command.simpleremote.command;

import com.study.command.simpleremote.Command;
import com.study.command.simpleremote.receiver.Stereo;

public class StereoOffWithCDCommand implements Command {

  private Stereo stereo;

  public StereoOffWithCDCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.off();
  }
}
