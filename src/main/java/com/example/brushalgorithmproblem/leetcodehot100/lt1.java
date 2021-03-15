package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/15 9:55 下午
 */
public class lt1 {

    //    一遍哈希 在遍历到一个新的元素的时候就看一看之前有没有匹配到的元素  并且这样计算是无后效性的
//    同时一次遍历也确保了一个元素不会被使用两遍
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(target - n)) {
                return new int[]{i, map.get(target - n)};
            }
            if (map.containsKey(n)) {
                map.replace(n, i);
            } else {
                map.put(n, i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        Arrays.stream(twoSum(nums, target)).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();
    }
}
