package com.example.writtenexaminationandinterview.gongsibishi.beike;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/12 8:00 下午
 */
public class t1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        TreeSet<Integer> min = new TreeSet<>();
        for (int i = 0; i < n; i++) {

            int k = in.nextInt();

            min.add(k);

            int s = hashMap.getOrDefault(k, 0);

            hashMap.put(k, s + 1);

        }

        int result = 0;
        while (min.size() > 2) {
//            key
            int m1 = min.pollFirst();
            int m2 = min.pollFirst();
//            System.out.println();

//            value
            int s1 = hashMap.get(m1);
            int s2 = hashMap.get(m2);

//            更新hashmap和min
            if (s1 < s2) {
                hashMap.remove(m1);
                hashMap.put(m1 + m2, hashMap.getOrDefault(m1 + m2, 0) + s1);
                hashMap.put(m2, s2 - s1);
                min.add(m1 + m2);
            } else if (s1 == s2) {
                min.add(m1 + m2);
                hashMap.remove(m1);
                hashMap.remove(m2);
                hashMap.put(m1 + m2, hashMap.getOrDefault(m1 + m2, 0) + s1);
            } else if (s1 > s2) {
                min.add(m1 + m2);
                hashMap.remove(s2);
                hashMap.put(m1, s1 - s2);
                hashMap.put(m1 + m2, hashMap.getOrDefault(m1 + m2, 0) + s2);

            }

        }
        System.out.println(hashMap.get(min.last()));
    }
}
