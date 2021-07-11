package com.example.designpatterns.chainOfResponsibility;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 7:45 下午
 */
//创建记录器类的实体类
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
