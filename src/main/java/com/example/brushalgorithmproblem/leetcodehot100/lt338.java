package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/29 9:56 下午
 */
//比特位计数
public class lt338 {

    //    常规算法
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            int k = i;
            int sum = 0;
            while (k > 0) {
                if ((k & 1) == 1) {
                    sum++;
                }
                k >>= 1;
            }
            result[i] = sum;
        }
        return result;
    }

    //    动态规划 最高有效位
    public static int[] countBits1(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
//            此时i为1，2，4，8，16...
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
//            此时在二进制表示中,i相当于在i-highBit之前加了个1
            result[i] = result[i - highBit] + 1;
        }
        return result;
    }

    //    动态规划 最低有效位
    public static int[] countBits2(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
//            直接处理最后一位
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {

        for (int i : countBits(5)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : countBits1(5)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : countBits2(5)) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}
