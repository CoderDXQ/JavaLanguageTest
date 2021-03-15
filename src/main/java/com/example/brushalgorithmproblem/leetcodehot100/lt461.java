package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/16 12:50 上午
 */
public class lt461 {

    //    利用异或运算同零异一的性质
    public static int hammingDistance(int x, int y) {
        int sum = 0;
        x ^= y;
        while (x > 0) {
            sum += (x & 1) == 1 ? 1 : 0;
            x >>= 1;
        }
        return sum;
    }

    //    模拟
    public static int hammingDistance1(int x, int y) {
        int sum = 0;
        while (x > 0 || y > 0) {
            sum += ((x & 1) == (y & 1)) ? 0 : 1;
            x >>= 1;
            y >>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(hammingDistance(x, y));
        System.out.println(hammingDistance1(x, y));
    }
}
