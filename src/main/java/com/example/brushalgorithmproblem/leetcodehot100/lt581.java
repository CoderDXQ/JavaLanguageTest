package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/4 8:42 下午
 */
//最短无序连续子数组
public class lt581 {

    //    排序后比较
    public static int findUnsortedSubarray(int[] nums) {

        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }

        Arrays.sort(nums1);

        int left = 0;
        int right = nums.length - 1;

        while (left < nums.length && nums1[left] == nums[left]) {
            left++;
        }

        while (right >= 0 && nums1[right] == nums[right]) {
            right--;
        }

        if (right < left) {
            return 0;
        }

        return right - left + 1;
    }

    //    单调栈
    public static int findUnsortedSubarray1(int[] nums) {

//        在栈里直接存放数组下标即可
        Stack<Integer> stack = new Stack<>();

//        比较变量的初始化
        int r = nums.length - 1, l = 0;

//        从左往右增单调栈 最大栈
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.push(stack.peek());
            } else {
//                包含相等的情况
                stack.push(i);
            }
        }

        while (!stack.isEmpty() && stack.peek() == r) {
            stack.pop();
            r--;
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.push(stack.peek());
            } else {
                stack.push(i);
            }
        }

        while (!stack.isEmpty() && stack.peek() == l) {
            stack.pop();
            l++;
        }

        return r - l > 0 ? r - l + 1 : 0;
    }

    //    单调栈
    public static int findUnsortedSubarray2(int[] nums) {

        Stack<Integer> stack = new Stack<>();

//        比较变量的初始化
        int l = nums.length, r = 0;

//        从左往右增单调栈 最大栈
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();

//        从右往左单调栈 最小栈
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }

        return r - l > 0 ? r - l + 1 : 0;
    }

    //    原地算法 https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leetcode/
//    结合最后一种方法的图形理解
    public static int findUnsortedSubarray3(int[] nums) {

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i - 1]) {
                flag = true;
            }

            if (flag) {
                min = Math.min(min, nums[i]);
            }

        }

        flag = false;

        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] > nums[i + 1]) {
                flag = true;
            }

            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }

        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (nums[l] > min) {
                break;
            }
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (nums[r] < max) {
                break;
            }
        }

        return r - l > 0 ? r - l + 1 : 0;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};

        System.out.println(findUnsortedSubarray(nums));
        System.out.println(findUnsortedSubarray1(nums));
        System.out.println(findUnsortedSubarray2(nums));
        System.out.println(findUnsortedSubarray3(nums));

    }

}
