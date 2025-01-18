package com.learning.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {

    public static void main(String[] args){

        Light light = new Light();
        Command turnOnCommand = new TurnOnCommand(light);
        Command turnOffLight = new TurnOffCommand(light);

        Invoker invoker = new Invoker();
        invoker.executeCommand(turnOnCommand);
        invoker.undo();

        invoker.executeCommand(turnOffLight);
        invoker.undo();
    }
}
