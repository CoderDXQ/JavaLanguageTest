package com.example.writtenexaminationandinterview.gongsibishi.ali;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/2 5:42 下午
 */
public class t1 {

    //    public static void test(int[] nums) {
//
//        Set<Integer> set = new HashSet<>();
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int n : nums) {
//            if (set.contains(n)) {
//                hashMap.put(n, hashMap.get(n) + 1);
//            } else {
//                hashMap.put(n, 1);
//                set.add(n);
//            }
//        }
//
//        int ans = set.size();
//
////        可能影响后面的
//        for (int n : set) {
////            System.out.print(n+" ");
//            int hg = hashMap.get(n);
//            if (hg > 1) {
//                if (!set.contains(n + 1)) {
//                    set.add(n + 1);
//                    hashMap.put(n, hashMap.get(n) - 1);
//                } else {
////                    hashMap.p
//                }
//            }
//        }
//
//        System.out.println(set.size());
//
//    }
    public static int solution(int[] arr, int n) {
        arr[n - 1]++;
        HashSet<Integer> set = new HashSet<>();
        set.add(arr[n - 1]);
        int count = 1;
        for (int i = n - 2; i >= 0; i--) {
            int newVal = arr[i] + 1;
            int oldVal = arr[i];
//            从后面开始  后面的先+1 给前面的让出来
//            可以认为是一种贪心策略 尽可能多的使用+1的权利
            if (!set.contains(newVal)) {
                arr[i]++;
                set.add(arr[i]);
                count++;
            } else if (!set.contains(oldVal)) {
                set.add(arr[i]);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t > 0) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

//            test(nums);
            System.out.println(solution(nums, n));

//            for (int i = 0; i < n; i++) {
//                System.out.print(nums[i]+" ");
//            }
//            System.out.println();

            t--;
        }

    }

}
