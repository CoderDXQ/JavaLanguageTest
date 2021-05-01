package com.example.brushalgorithmproblem.swordtooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 10:55 下午
 */
//数组中重复的数字
public class JZ50 {

    public static int duplicate(int[] numbers) {
        int result = -1;
        Set set = new HashSet();

        for (int num : numbers) {
            if (set.contains(num)) {
                result = num;
                break;
            } else {
                set.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] numbers = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(numbers));

    }
}
