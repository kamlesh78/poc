package com.learning.chainOfResponsibility;

public class MainLoggerHelper {

    public static void main(String[] args){

        Logger infoLogger = new InfoLogger();
        Logger debugLogger = new DebugLogger();
        Logger errorLogger = new ErrorLogger();

        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        infoLogger.log(LogLevel.DEBUG,"hello world");
    }
}
