package com.learning.chainOfResponsibility;

import lombok.Data;

@Data
public abstract class Logger {
    private Logger nextLogger;
    public void setNextLogger(Logger logger){
        this.nextLogger = logger;
    }
    public void log(LogLevel logLevel,String message){
        if(canHandleLog(logLevel)){
            write(message);
        } else if (nextLogger != null) {
            nextLogger.log(logLevel,message);
        }
    }
    protected abstract boolean canHandleLog(LogLevel logLevel);

    protected abstract void write(String message);
}
