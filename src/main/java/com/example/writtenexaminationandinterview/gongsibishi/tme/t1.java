package com.example.writtenexaminationandinterview.gongsibishi.tme;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/15 7:13 下午
 */
public class t1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();


        while (t > 0) {

            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int k = in.nextInt();
                hashMap.put(k, hashMap.getOrDefault(k, 0) + 1);
            }

            int k = -1;
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() == 1 && (entry.getKey() < k || k == -1)) {
                    k = entry.getKey();
                }
            }

            System.out.println(k);
            t--;
        }


    }
}
