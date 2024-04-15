package com.study.command.simpleremote;

import com.study.command.simpleremote.command.LightOffCommand;
import com.study.command.simpleremote.command.LightOnCommand;
import com.study.command.simpleremote.command.MacroCommand;
import com.study.command.simpleremote.command.StereoOffCommand;
import com.study.command.simpleremote.command.StereoOnWithCDCommand;
import com.study.command.simpleremote.invoker.RemoteControlWithUndo;
import com.study.command.simpleremote.receiver.Light;
import com.study.command.simpleremote.receiver.Stereo;

public class RemotePartyLoader {

  public static void main(String[] args) {
    Light light = new Light("Living Room");
    Stereo stereo = new Stereo("Living Room");

    LightOnCommand lightOnCommand = new LightOnCommand(light);
    LightOffCommand lightOffCommand = new LightOffCommand(light);
    StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
    StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

    MacroCommand macroOnCommand = new MacroCommand(
        new Command[]{lightOnCommand, stereoOnWithCDCommand});

    MacroCommand macroOffCommand = new MacroCommand(
        new Command[]{lightOffCommand, stereoOffCommand});

    RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();
    remoteControlWithUndo.setCommands(0, macroOnCommand, macroOffCommand);

    remoteControlWithUndo.onButtonWasPushed(0);
    remoteControlWithUndo.offButtonWasPushed(0);
    remoteControlWithUndo.undoButtonWasPushed();
  }

}
