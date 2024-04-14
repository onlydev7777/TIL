package com.study.command.simpleremote;

import com.study.command.simpleremote.command.GarageDoorDownCommand;
import com.study.command.simpleremote.command.GarageDoorUpCommand;
import com.study.command.simpleremote.command.LightOffCommand;
import com.study.command.simpleremote.command.LightOnCommand;
import com.study.command.simpleremote.command.StereoOffCommand;
import com.study.command.simpleremote.command.StereoOnWithCDCommand;
import com.study.command.simpleremote.invoker.RemoteControl;
import com.study.command.simpleremote.receiver.GarageDoor;
import com.study.command.simpleremote.receiver.Light;
import com.study.command.simpleremote.receiver.Stereo;

public class RemoteLoader {

  public static void main(String[] args) {
    RemoteControl remoteControl = new RemoteControl();

    Light livingRoomLight = new Light("Living Room");
    Light kitchenLight = new Light("Kitchen");
    GarageDoor garageDoor = new GarageDoor("Main house");
    Stereo stereo = new Stereo("Living Room");

    LightOnCommand livingRoomLightOn =
        new LightOnCommand(livingRoomLight);
    LightOffCommand livingRoomLightOff =
        new LightOffCommand(livingRoomLight);
    LightOnCommand kitchenLightOn =
        new LightOnCommand(kitchenLight);
    LightOffCommand kitchenLightOff =
        new LightOffCommand(kitchenLight);

    GarageDoorUpCommand garageDoorUp =
        new GarageDoorUpCommand(garageDoor);
    GarageDoorDownCommand garageDoorDown =
        new GarageDoorDownCommand(garageDoor);

    StereoOnWithCDCommand stereoOnWithCD =
        new StereoOnWithCDCommand(stereo);
    StereoOffCommand stereoOff =
        new StereoOffCommand(stereo);

    remoteControl.setCommands(0, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommands(1, kitchenLightOn, kitchenLightOff);
    remoteControl.setCommands(2, garageDoorUp, garageDoorDown);
    remoteControl.setCommands(3, stereoOnWithCD, stereoOff);

    System.out.println(remoteControl);

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(1);
    remoteControl.offButtonWasPushed(1);
    remoteControl.onButtonWasPushed(2);
    remoteControl.offButtonWasPushed(2);
    remoteControl.onButtonWasPushed(3);
    remoteControl.offButtonWasPushed(3);
  }
}
