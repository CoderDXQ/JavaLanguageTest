package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.HashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/21 7:54 下午
 */
//和为k的子数组
public class lt560 {

    //    前缀和+hashmap优化
    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        for (int n : nums) {
            sum += n;
//            sum - k是被减去的那个前缀 k=后前缀-前前缀
            if (hashMap.containsKey(sum - k)) {
                result += hashMap.get(sum - k);
            }
//            getOrDefault()方法：有这个key时就执行get，否则就使用Default值
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }

}
