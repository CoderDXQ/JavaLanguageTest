package com.example.bishimianshi.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 3:52 下午
 */
public class t3 {

    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        int num;
        for (int i = 0; i < n; i++) {
            num = in.nextInt();
            if (first.containsKey(num)) {
                last.replace(num, i + 1);
            } else {
                first.put(num, i + 1);
                last.put(num, i + 1);
            }
        }


        for (int i = 0; i < m; i++) {
            num = in.nextInt();
            if (!first.containsKey(num)) {
                System.out.println(0);
            } else {
                System.out.println(first.get(num) + " " + last.get(num));
            }
        }
    }

}
