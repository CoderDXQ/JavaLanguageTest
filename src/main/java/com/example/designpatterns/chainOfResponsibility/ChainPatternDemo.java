package com.example.designpatterns.chainOfResponsibility;

import lombok.val;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 7:46 下午
 */
//手动构造的责任链
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
//        构造责任链
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        System.out.println();
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug level information");
        System.out.println();
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");

    }
}
