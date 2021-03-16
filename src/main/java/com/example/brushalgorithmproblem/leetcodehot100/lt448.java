package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/16 10:29 上午
 */
public class lt448 {

    //    原位数组操作  利用了求余的性质
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
//        n=nums.length
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % nums.length] += nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
//            等号代表原来数组中的数是n的情况
            if (nums[i] <= nums.length) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};

//        5,6
        findDisappearedNumbers(nums).forEach(a -> {
            System.out.print(a + " ");
        });

        System.out.println();
    }
}
