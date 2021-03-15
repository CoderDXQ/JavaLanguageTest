package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/15 3:58 下午
 */
public class lt136 {

    //    不使用额外空间就是不能标记  可以利用位运算中异或的性质来解决
//    性质1：同零异一 同一位上的两个数进行异或计算  这一位的结果为：相同为0，不同为1
//    性质2：任何数和0做异或结果都是原来的数
//    性质3：异或运算满足交换律和结合律
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};

        System.out.println(singleNumber(nums));
    }
}
