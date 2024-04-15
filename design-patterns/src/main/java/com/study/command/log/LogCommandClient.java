package com.study.command.log;

import com.study.command.log.command.LightOnCommand;
import com.study.command.log.command.StereoOnCommand;
import com.study.command.log.invoker.LogCommand;
import com.study.command.log.receiver.Light;
import com.study.command.log.receiver.Stereo;

public class LogCommandClient { //Client

  public static void main(String[] args) {
    //Invoker
    LogCommand logCommand = new LogCommand();

    //Receiver
    Light light = new Light("Living Room");
    Stereo stereo = new Stereo("Living Room");

    //Command
    LightOnCommand lightOnCommand = new LightOnCommand(light);
    StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);

    logCommand.setCommand(lightOnCommand);
    logCommand.buttonOnPushed();

    logCommand.setCommand(stereoOnCommand);
    logCommand.buttonOnPushed();

    logCommand.historyPrint();
  }
}
