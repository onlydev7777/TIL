package com.study.command.simpleremote.command;

import com.study.command.simpleremote.Command;
import com.study.command.simpleremote.receiver.Stereo;

public class StereoOnWithCDCommand implements Command {

  private Stereo stereo;

  public StereoOnWithCDCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.on();
    stereo.setCd("bigbang - blue");
    stereo.setVolume(11);
  }
}
