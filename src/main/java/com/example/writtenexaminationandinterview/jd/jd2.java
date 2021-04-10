package com.example.writtenexaminationandinterview.jd;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/10 7:56 下午
 */
public class jd2 {

    public static int result;

    public static void jisuan(int[] nums, Stack<Integer> left, Stack<Integer> right, int k) {

        if (nums.length == left.size() + right.size()) {

            int num = 0;

            Stack<Integer> l=new Stack<>();
            l.addAll(left);

            if (!l.isEmpty()) {
                int s = l.pop();
                while (!l.isEmpty()) {
                    if (s == l.pop()) {
                        num++;
                    }
                }
            }

            Stack<Integer> r=new Stack<>();
            r.addAll(right);
            if (!r.isEmpty()) {
                int s = r.pop();
                while (!r.isEmpty()) {
                    if (s == r.pop()) {
                        num++;
                    }
                }
            }

            result = Math.max(num, result);

        }

        int i=k;

        if (i<nums.length){

            left.push(nums[i]);
            jisuan(nums, left, right, i + 1);

            left.pop();

            right.push(nums[i]);
            jisuan(nums, left, right, i + 1);
//            right.pop();

        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        result = 0;
        jisuan(nums, left, right, 0);

        System.out.println(result);

    }

}
