package com.example.writtenexaminationandinterview.gongsibishi.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 3:52 下午
 */
public class t5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int num = 0;
        List<Integer> list = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            int ji = 0;
            int ou = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    if (i % 2 == 1) {
                        ji += nums[i];
                    } else {
                        ou += nums[i];
                    }
                } else if (i > k) {
                    if (i % 2 == 1) {
                        ou += nums[i];
                    } else {
                        ji += nums[i];
                    }
                }
            }
            if (ji == ou) {
                num++;
                list.add(k + 1);
            }
        }

        if (num == 0) {
            System.out.println(0);
        } else {
            System.out.println(num);
            list.forEach(System.out::println);
        }

    }


}
