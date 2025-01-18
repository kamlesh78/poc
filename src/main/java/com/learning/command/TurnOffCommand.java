package com.learning.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurnOffCommand implements Command{
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}
