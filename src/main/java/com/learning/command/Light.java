package com.learning.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Light {
    public void turnOn(){
        System.out.println("Light Turned on");
    }

    public void turnOff(){
        System.out.println("Light Turned off");
    }
}
