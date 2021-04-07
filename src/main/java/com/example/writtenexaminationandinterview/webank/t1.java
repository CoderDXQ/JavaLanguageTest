package com.example.writtenexaminationandinterview.webank;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 6:56 下午
 */

//AK!
public class t1 {

//     最大栈 省一半的遍历

    public static int[] stack;

    public static int result = 0;

    public static void check(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < stack[i]) {
                continue;
            }
            boolean flag = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    flag = true;
                }
            }
            if (flag == true) {
                continue;
            }
            result++;
        }

        System.out.println(result);

    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        stack = new int[n];
        for (int i = 0; i < n; i++) {

            nums[i] = in.nextInt();
            if (i == 0) {
                stack[i] = nums[i];
            } else {
                if (nums[i] >= stack[i - 1]) {
                    stack[i] = nums[i];
                } else {
                    stack[i] = stack[i - 1];
                }
            }
        }

        check(nums);

    }


}
