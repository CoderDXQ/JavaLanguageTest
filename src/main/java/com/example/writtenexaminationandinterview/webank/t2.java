package com.example.writtenexaminationandinterview.webank;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 6:57 下午
 */
public class t2 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        List<Set<Integer>> lists = new ArrayList<>();
        int index = 0;
        while (m > 0) {
            int a = in.nextInt();
            int b = in.nextInt();

            if (lists.isEmpty()) {
                Set<Integer> s1 = new HashSet<>();
                s1.add(a);
                s1.add(b);
                lists.add(s1);
            } else {
//            这样做可能有缺陷
                boolean flag = false;
                for (int i = 0; i <= index; i++) {
                    Set<Integer> set = lists.get(i);
                    if (set.contains(a) || set.contains(b)) {
                        flag = true;
                        set.add(a);
                        set.add(b);
                        break;
                    }
                }
                if (flag == false) {
                    index++;
                    Set<Integer> s1 = new HashSet<>();
                    s1.add(a);
                    s1.add(b);
                    lists.add(s1);
                }
            }
            m--;
        }

        double[] result = new double[n];
//        处理水
        for (int i = 0; i <= index; i++) {
            int sum = 0;
            for (int s : lists.get(i)) {
                sum += nums[s - 1];
            }
            double pj = (double) sum / lists.get(i).size();
            for (int s : lists.get(i)) {
                result[s - 1] = pj;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%.2f", result[i]);
            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();


    }
}
