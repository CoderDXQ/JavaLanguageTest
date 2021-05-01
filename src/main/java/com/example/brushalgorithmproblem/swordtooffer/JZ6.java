package com.example.brushalgorithmproblem.swordtooffer;

import static java.lang.Integer.min;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/30 12:47 上午
 */
//旋转数组的最小数字
public class JZ6 {

    //    这个方法比剑指offer上的要巧妙
    public int minNumberInRotateArray(int[] array) {

        int left, mid, right;
        left = 0;
        right = array.length - 1;
        mid = (left + right) >> 1;

        while (left < right) {//left==right时即为所求答案
//            这个题的坑点比较多，要面向测试用例编程
            if (array[left] < array[right]) return array[left];
            if (array[left] < array[mid]) {
                left = mid + 1;
            } else if (array[left] > array[mid]) {
                right = mid;
            } else {
//                这里可以避免{1, 1, 0, 1, 1, 1, 1, 1}的情况，因为此时array[left]==array[mid]==array[right]
                left++;
            }
            mid = (left + right) >> 1;
        }
        return min(min(array[left], array[mid]), min(array[mid], array[right]));
    }

    public static void main(String[] args) {
//        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
//        一种特殊情况
        int[] arr = {1, 1, 0, 1, 1, 1, 1, 1};
        JZ6 solution = new JZ6();
        System.out.println(solution.minNumberInRotateArray(arr));
    }
}
