package com.study.command.queue;

import com.study.command.queue.command.LightOnCommand;
import com.study.command.queue.command.StereoOnCommand;
import com.study.command.queue.invoker.QueueCommand;
import com.study.command.queue.receiver.Light;
import com.study.command.queue.receiver.Stereo;

public class QueueCommandClient { //Client

  public static void main(String[] args) {
    //Invoker
    QueueCommand queueCommand = new QueueCommand();

    //Receiver
    Light light = new Light("Living Room");
    Stereo stereo = new Stereo("Living Room");

    //Command
    LightOnCommand lightOnCommand = new LightOnCommand(light);
    StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);

    queueCommand.addCommand(lightOnCommand);
    queueCommand.addCommand(stereoOnCommand);

    queueCommand.executeQueue();
    queueCommand.executeQueue();
  }
}
