package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/21 10:38 上午
 */
//三数之和
public class lt15 {

    public static List<List<Integer>> result;

    //    暴力 并且有重复 最终超时
    public static List<List<Integer>> threeSum(int[] nums) {
        result = new LinkedList<>();

//        使用set去重
        Set<List<Integer>> set = new HashSet<>();

//        排序
        Arrays.sort(nums);

//        加剪枝
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                result.addAll(set);
                return result;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                for (int k = nums.length - 1; k > j; k--) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        将数组转换为链表
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        break;
                    }
                }
            }
        }

        result.addAll(set);
        return result;
    }

    //    双指针 首尾指针各自只能向一个方向移动
    public static List<List<Integer>> threeSum1(int[] nums) {
        result = new LinkedList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
//          去重  防止漏掉0，0，0的答案  并且防止与前面进行重复计算得到重复结果 不能是nums[i]==nums[i++]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {

                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
//                    去重 使用Set去重可能更简单
                    while (left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};

        threeSum(nums).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.print(", ");
        });

        System.out.println();

        threeSum1(nums).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.print(", ");
        });

    }
}
