package com.example.bishimianshi.inout;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 9:52 上午
 */
public class t7 {

    //    https://ac.nowcoder.com/acm/contest/5652/G
//    这种情况需要整行读字符串 然后把字符串处理成整型
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
//            处理字符串
            String[] s = in.nextLine().split(" ");
            int sum = 0;
            for (String ss : s) {
                sum += Integer.valueOf(ss);
            }
            System.out.println(sum);
        }
    }
}
