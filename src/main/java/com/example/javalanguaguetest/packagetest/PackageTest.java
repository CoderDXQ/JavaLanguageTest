package com.example.javalanguaguetest.packagetest;


import com.example.javalanguaguetest.packagetest.classone.ClassOne;
import com.example.javalanguaguetest.packagetest.classtwo.ClassTwo;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/29 8:17 下午
 */
public class PackageTest {
    public static void main(String[] args) {
        //使用其他两个包下的类的方法
        ClassOne a = new ClassOne();
        ClassTwo b = new ClassTwo();

        a.methodone();
        b.methodtwo();

    }
}
