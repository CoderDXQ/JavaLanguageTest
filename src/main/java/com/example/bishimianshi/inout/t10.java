package com.example.bishimianshi.inout;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 10:13 上午
 */
public class t10 {

    //    https://ac.nowcoder.com/acm/contest/5652/J
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] st = in.nextLine().split(",");
            Arrays.sort(st);
            System.out.println(String.join(",", st));
        }
    }
}
