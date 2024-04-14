package com.study.command.simpleremote;

import com.study.command.simpleremote.command.CeilingFanHighCommand;
import com.study.command.simpleremote.command.CeilingFanMediumCommand;
import com.study.command.simpleremote.command.CeilingFanOffCommand;
import com.study.command.simpleremote.command.LightOffCommand;
import com.study.command.simpleremote.command.LightOnCommand;
import com.study.command.simpleremote.invoker.RemoteControlWithUndo;
import com.study.command.simpleremote.receiver.CeilingFan;
import com.study.command.simpleremote.receiver.Light;

public class RemoteLoaderWithUndo {

  public static void main(String[] args) {
    RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

    Light livingRoomLight = new Light("Living Room");

    LightOnCommand livingRoomLightOn =
        new LightOnCommand(livingRoomLight);
    LightOffCommand livingRoomLightOff =
        new LightOffCommand(livingRoomLight);

    remoteControl.setCommands(0, livingRoomLightOn, livingRoomLightOff);

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();
    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();

    CeilingFan ceilingFan = new CeilingFan("Living Room");

    CeilingFanMediumCommand ceilingFanMedium =
        new CeilingFanMediumCommand(ceilingFan);
    CeilingFanHighCommand ceilingFanHigh =
        new CeilingFanHighCommand(ceilingFan);
    CeilingFanOffCommand ceilingFanOff =
        new CeilingFanOffCommand(ceilingFan);

    remoteControl.setCommands(0, ceilingFanMedium, ceilingFanOff);
    remoteControl.setCommands(1, ceilingFanHigh, ceilingFanOff);

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();

    remoteControl.onButtonWasPushed(1);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();
  }
}
