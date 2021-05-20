package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 10:44 下午
 */
//接雨水
public class lt42 {

    //    动态规划
    public static int trap(int[] height) {

        int n = height.length;

        if (n == 0) {
            return 0;
        }

//        计算单调数组
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

//        计算
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    //    单调栈
    public static int trap1(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
//                height[left],height[top],height[i]形成一个坑或者坑的局部
//                每次都添加一小块
                int curHeight = Math.min(height[left], height[i]) - height[top];
                ans += curHeight * curWidth;
            }
            stack.push(i);
        }
        return ans;
    }

    //    双指针 这里用的规律需要推导一下
    public static int trap2(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
//                此时 leftMax<rightMax
                ans += leftMax - height[left];
                left++;
            } else {
//                此时 leftMax>=rightMax
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    //    按高度走 按行求 超时
    public static int trap3(int[] height) {

        int ans = 0;

        int max = getMax(height);

//        枚举高度
        for (int i = 1; i <= max; i++) {

//            信号量  标志是否开始计算
            boolean isStart = false;

            int temp_sum = 0;

//          横向遍历
            for (int j = 0; j < height.length; j++) {

//                统计这个坑在这个高度山的面积
                if (isStart && height[j] < i) {
                    temp_sum++;
                }

//                遇到了坑的边缘
                if (height[j] >= i) {
                    ans += temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return ans;
    }

    public static int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

    //    从左到右走 按列求
    public static int trap4(int[] height) {

        int ans = 0;

        int n = height.length;

        for (int i = 0; i < n - 1; i++) {

            int maxLeft = 0, maxRight = 0;

//            寻找当前的坑的左边界
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

//            寻找当前的坑的右边界
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

//            每次只加上当前的水柱
            ans += Math.min(maxLeft, maxRight) - height[i];

        }

        return ans;
    }


    public static void main(String[] args) {

        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height1 = new int[]{4, 2, 0, 3, 2, 5};

        System.out.println(trap(height));
        System.out.println(trap(height1));
        System.out.println();

        System.out.println(trap1(height));
        System.out.println(trap1(height1));
        System.out.println();

        System.out.println(trap2(height));
        System.out.println(trap2(height1));
        System.out.println();

        System.out.println(trap3(height));
        System.out.println(trap3(height1));
        System.out.println();

        System.out.println(trap4(height));
        System.out.println(trap4(height1));
        System.out.println();

    }

}
