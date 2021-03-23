package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/23 10:21 下午
 */
public class lt33 {

    //    二分查找
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
//        ???=
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
//            分形态
            if (nums[0] <= nums[mid]) {
//                这里是两个条件  只能是0不能换成left
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[nums.length - 1] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int target = 0;
        int[] nums = new int[]{1, 3};

        System.out.println(search(nums, target));

    }
}
