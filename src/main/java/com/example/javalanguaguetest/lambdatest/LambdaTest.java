package com.example.javalanguaguetest.lambdatest;

import javax.swing.*;

import java.util.Arrays;
import java.util.Date;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/3 9:49 下午
 */
//lambda表达式主要用于简化一些匿名内部类的写法 超过三行的逻辑不建议使用lambda表达式 语法糖
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars"};
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted in dictionary order:");
        //默认排序方式就是字典序
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted by length:");
        //lambda表达式控制排序
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        //lambda表达式控制多线程
        Timer t = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        t.start();

        //Swing
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
