package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/3 11:16 下午
 */
public class JZ40 {

    /**
     * 异或运算：
     * 两个相同的数的异或结果为0
     * 0和任何数的异或结果不影响原来的数
     * <p>
     * 这个题限制了：重复的数字只出现两次 否则没法用位运算来做
     */

//    不用额外的存储空间的方法
    public static int[] FindNumsAppearOnce(int[] array) {

        int[] result = new int[]{0, 0};
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            x ^= array[i];
        }

//        此时的x的值与两个只出现一次的数的异或结果是相同的 需要从x中分离出这两个数
//        这两个数在进行异或运算时，如果某位数字上数字不同那么这一位的异或结果就是1
//        提取这一位
        int m = 1;
        while ((x & m) == 0) {
            m <<= 1;
        }

//        使用m来进行分组顺便进行异或运算
        for (int i = 0; i < array.length; i++) {

//            检查某位是否为0
            if ((array[i] & m) == 0) {
                result[0] ^= array[i];
            } else {
                result[1] ^= array[i];
            }
        }

        int k;
        if (result[0] > result[1]) {
            k = result[0];
            result[0] = result[1];
            result[1] = k;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] array = new int[]{1, 4, 1, 6, 5, 5};
        int[] result = FindNumsAppearOnce(array);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
