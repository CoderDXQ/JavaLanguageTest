package com.example.javalanguaguetest.runtimetest.waitfor;

import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/16 9:54 上午
 */
public class TestCommandUtil {
    public static void main(String[] args) {
        CommandUtil commandUtil = new CommandUtil();
        commandUtil.executeCommand("javac");
        printList(commandUtil.getStdotList());
        System.out.println("--------------------");
        printList(commandUtil.getErorList());
    }

    public static void printList(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }
}
