package com.study.command.simpleremote;

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

    remoteControl.setCommands(0, livingRoomLight::on, livingRoomLight::off);
    remoteControl.setCommands(1, kitchenLight::on, kitchenLight::off);

    Command stereoOnWithCD = () -> {
      stereo.on();
      stereo.setCd("bigbang - blue");
      stereo.setVolume(11);
    };
    remoteControl.setCommands(2, stereoOnWithCD, stereo::off);
    remoteControl.setCommands(3, garageDoor::up, garageDoor::down);

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
