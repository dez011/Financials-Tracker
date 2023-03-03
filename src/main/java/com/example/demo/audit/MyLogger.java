package com.example.demo.audit;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
    private static final Logger LOGGER = Logger.getLogger(MyLogger.class.getName());
    private static ConsoleHandler consoleHandler = new ConsoleHandler();

    public static void logInfo(String message){
        consoleHandler.setLevel(Level.FINE);
        LOGGER.info(message);
        System.out.println(message);
    }

    //Add more loggers
}
