package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/24 1:15 上午
 */

//在排序数组中查找元素的第一个和最后一个位置
public class lt34 {

    //    二分查找
    public static int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (nums[mid] != target) {
            return new int[]{-1, -1};
        }

        left = mid;
        right = mid;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right <= nums.length - 1 && nums[right] == target) {
            right++;
        }

        return new int[]{left + 1, right - 1};

    }


    //    二分其实就是一个选择左右区间的问题
    public static int[] searchRange1(int[] nums, int target) {
        int left = find(nums, target, true);
        int right = find(nums, target, false) - 1;
        if (left >= 0 && right <= nums.length - 1 && left <= right && left <= nums.length - 1 && right >= 0) {
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }

    //    lower标识是否正在查找左侧区间值 提高代码复用度
    public static int find(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        int ans = nums.length;

        while (left <= right) {
            mid = (left + right) >> 1;
//            选取左侧的情况
            if (nums[mid] > target || (lower == true && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
//                选取右侧的情况
                left = mid + 1;
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 4};
        int target = 4;

        for (int i : searchRange(nums, target)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : searchRange1(nums, target)) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
