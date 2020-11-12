package com.example.javalanguaguetest.input;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/12 11:13 上午
 */
public class InputTest {
    public static void main(String[] args) {
        //java从键盘输入的一种方式
        Scanner in = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = in.nextLine();

        System.out.println("How old are you?");
        int age = in.nextInt();

        System.out.println("Hello " + name + ",Next year you will be " + (age + 1));
    }
}
