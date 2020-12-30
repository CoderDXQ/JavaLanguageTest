package com.example.javalanguaguetest.callback.easy3;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 9:35 下午
 */
public class Test {
    public static void main(String[] args) {
        Student st = new Student();
        Teacher th = new Teacher(st);

        th.askQuestion("1+1=?");
    }
}
