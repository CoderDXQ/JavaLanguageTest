package com.example.atest;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/20 3:53 下午
 */
public class test3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inn = in.nextLine();
        String[] hang = inn.split(";");
        String[][] table = new String[hang.length][hang[0].length()];

        System.out.println(2 * (hang.length - 1));
    }
}
