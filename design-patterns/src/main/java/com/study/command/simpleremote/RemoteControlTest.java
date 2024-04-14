package com.study.command.simpleremote;

import com.study.command.simpleremote.command.GarageDoorOpenCommand;
import com.study.command.simpleremote.command.LightOnCommand;
import com.study.command.simpleremote.invoker.SimpleRemoteControl;
import com.study.command.simpleremote.receiver.GarageDoor;
import com.study.command.simpleremote.receiver.Light;

public class RemoteControlTest {

  public static void main(String[] args) {
    Light light = new Light("Living Room");
    LightOnCommand lightOnCommand = new LightOnCommand(light);

    SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl(lightOnCommand);
    simpleRemoteControl.buttonWasPressed();

    GarageDoor garageDoor = new GarageDoor("");
    GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
    simpleRemoteControl.changeSlot(garageDoorOpenCommand);

    simpleRemoteControl.buttonWasPressed();
  }
}
