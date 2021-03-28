package com.example.brushalgorithmproblem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 3:29 下午
 */
public class lt137 {

    //    int是32位的
    public static int singleNumber(int[] nums) {
//        处理每一位
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sumOfBit = 0;
            for (int n : nums) {
//                无符号右移 注意优先级
                if (((n >>> i) & 1) == 1) {
                    sumOfBit++;
                }
            }
            if (sumOfBit % 3 == 1) {
                result = (1 << i) | result;
            }
        }
        return result;
    }

    public static int singleNumber1(int[] nums) {
//        处理每一位
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sumOfBit = 0;
            for (int n = 0; n < nums.length; n++) {
//                无符号右移 注意优先级
                if ((nums[n] & 1) == 1) {
                    sumOfBit++;
                }
                nums[n] >>>= 1;
            }
            if (sumOfBit % 3 == 1) {
                result = (1 << i) | result;
            }
        }
        return result;
    }

    //    算数方法
    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for (int n : nums) {
            sum += n;
            set.add(n);
        }
        long sum1 = 0;
        for (int n : set) {
            sum1 += n;
        }
        return (int) ((sum1 * 3 - sum) >> 1);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 99};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber1(nums));
        System.out.println(singleNumber2(nums));
    }

}
