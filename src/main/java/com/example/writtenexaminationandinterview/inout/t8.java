package com.example.writtenexaminationandinterview.inout;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 9:56 上午
 */
public class t8 {

//    https://ac.nowcoder.com/acm/contest/5652/H
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
////        吸收回车符
//        in.nextLine();
//        String[] st = in.nextLine().split(" ");
//        Arrays.sort(st);
////        有些评测系统会自动吞掉后面的空格
//        for (String s : st) {
//            System.out.print(s + " ");
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        吸收回车符
        in.nextLine();
        String[] st = in.nextLine().split(" ");
        Arrays.sort(st);

//        使用String类的自动拼接
        System.out.println(String.join(" ", st));

    }

}
