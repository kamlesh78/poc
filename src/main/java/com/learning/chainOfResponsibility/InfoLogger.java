package com.learning.chainOfResponsibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoLogger extends Logger{
    @Override
    protected boolean canHandleLog(LogLevel logLevel) {
        if(logLevel.name().equalsIgnoreCase(LogLevel.INFO.name())){
            return true;
        }
        return false;
    }

    @Override
    protected void write(String message) {
        System.out.println("Info Log :: " + message);
    }
}
