package com.study.command.queue.invoker;

import com.study.command.queue.Command;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCommand {

  private Queue<Command> commandQueue;

  public QueueCommand() {
    this.commandQueue = new LinkedList<>();
  }

  public void addCommand(Command command) {
    this.commandQueue.add(command);
  }

  public void executeQueue() {
    Command poll = commandQueue.poll();
    if (poll != null) {
      poll.execute();
    }
  }
}
