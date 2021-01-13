package com.example.javalanguaguetest.string;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/13 2:02 下午
 */
public class StringTest {
    public static void main(String[] args) {

        String logpath = "/home/dtslinux/DTS/fl.db";

        logpath = logpath.substring(0, logpath.lastIndexOf('/') + 1);
        System.out.println(logpath);

    }
}
