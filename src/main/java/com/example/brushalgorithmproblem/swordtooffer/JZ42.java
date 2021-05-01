package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 10:34 下午
 */
//和为S的两个数字
//根据算数规律，两个数的差值越大其积越小，因此找到最外层的答案即可
public class JZ42 {

    //    双指针
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();

        int left = 0, right = array.length - 1;
        while (left <= right) {
//            System.out.println(array[left] + " " + array[right]);
            if (array[left] + array[right] < sum) {
                left++;
            } else if (array[left] + array[right] > sum) {
                right--;
            } else if (array[left] + array[right] == sum) {
                result.add(array[left]);
                result.add(array[right]);
                break;
            }
        }

        return result;
    }

    //    哈希
    public static ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();

        for (int a : array) {
            if (record.containsKey(a)) {
                record.put(a, record.get(a) + 1);
            } else {
                record.put(a, 1);
            }
        }

        for (int a : array) {
            if (record.containsKey(sum - a)) {
                result.add(a);
                result.add(sum - a);
//                剪枝
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int sum = 15;
        int[] array = new int[]{1, 2, 4, 7, 11, 15};

        FindNumbersWithSum(array, sum).forEach(arr -> {
            System.out.print(arr + " ");
        });

        System.out.println();

        FindNumbersWithSum1(array, sum).forEach(arr -> {
            System.out.print(arr + " ");
        });

    }
}
