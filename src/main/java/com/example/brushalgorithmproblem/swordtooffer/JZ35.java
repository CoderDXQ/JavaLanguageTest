package com.example.brushalgorithmproblem.swordtooffer;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/12 11:44 下午
 */
public class JZ35 {

    //    暴力方法 用于验证其他算法结果的准确性和性能比较
    public static int InversePairs(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    sum++;
                }
            }
        }
        return sum % 1000000007;
    }

    public static int InversePairs1(int[] array) {
        int sum = 0;


        return sum;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
//        7
        Long start = System.currentTimeMillis();
        System.out.println(InversePairs(array));
        System.out.println("Spending time: " + (System.currentTimeMillis() - start));
        System.out.println();

        start = System.currentTimeMillis();
        System.out.println(InversePairs1(array));
        System.out.println("Spending time: " + (System.currentTimeMillis() - start));
        System.out.println();
    }
}
