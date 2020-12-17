package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/17 12:18 上午
 */
public class JZ13 {
    //??????java怎么在函数之间传递引用？？？
    public static void main(String[] args) {
        JZ13 solution = new JZ13();
        int[] array = {1, 2, 3, 5, 6, 7, 9, 4, 6, 8};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
     //   solution.reOrderArray(array);
        solution.reOrderArray1(array);
    }

//时间复杂度和空间复杂度均为n
    public void reOrderArray(int[] array) {
        Stack<Integer> ji = new Stack<Integer>();
        Stack<Integer> ou = new Stack<Integer>();

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();


        for (int i = array.length - 1; i >= 0; i--) {
            if ((array[i] & 1) == 1) {
                ji.push(array[i]);
            } else {
                ou.push(array[i]);
            }
        }

        int i = 0;
        while (!ji.empty()) {
            array[i++] = ji.pop();
        }
        while (!ou.empty()) {
            array[i++] = ou.pop();
        }
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    //in-place算法 空间复杂度为1，时间复杂度为n
    public void reOrderArray1(int[] array) {
        //i是下一个要插入的数的下标
        int i = 0;
        for (int j = 0; j < array.length; ++j) {
//            不能简写
            if ((array[j] & 1) == 1) {
                int tmp = array[j];
                //向后移动
                for (int k = j - 1; k >= i; --k) {
                    array[k + 1] = array[k];
                }
                array[i++] = tmp;
            }


            System.out.println();
            for (int ii = 0; ii < array.length; ii++) {
                System.out.print(array[ii] + " ");
            }
            System.out.println();
        }
//        System.out.println();
//        System.out.println();
//        for (i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
    }
}
