package com.learning.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurnOnCommand implements Command{
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}
