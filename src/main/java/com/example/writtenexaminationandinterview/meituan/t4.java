package com.example.writtenexaminationandinterview.meituan;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 3:52 下午
 */
public class t4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }


        if(n==0){
            System.out.println(0);
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            max = Math.max(max, num);
            for (int j = i + 1; j < nums.length && j < i + k; j++) {
                num = num ^ nums[j];
                max = Math.max(max, num);
            }
        }

        System.out.println(max);

    }


}
