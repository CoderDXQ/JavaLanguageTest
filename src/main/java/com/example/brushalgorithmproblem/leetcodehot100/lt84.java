package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 10:45 下午
 */
//柱状图中最大的矩形
public class lt84 {

    //    暴力解法 枚举宽 超时
    public static int largestRectangleArea(int[] heights) {
//        初始化
        int ans = 0;
//        枚举左侧起点
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
//            枚举右侧终点  同时得到宽度
            for (int j = i; j < heights.length; j++) {
//                获得当前的最小值
                minHeight = Math.min(minHeight, heights[j]);
                ans = Math.max(ans, (j - i + 1) * minHeight);
            }
        }
        return ans;
    }

    //    单调栈 找到两边第一个小于它的值然后都向内移一下就找到了矩形宽的边界，从而也就得到了宽的值
    public static int largestRectangleArea1(int[] heights) {

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

//        从左到右
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
//        从右到左
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    //    单调栈优化 哨兵机制  实质上就是在执行过程中有个覆盖过程
    public static int largestRectangleArea2(int[] heights) {

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

//      设置为n 以后会被覆盖
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                会覆盖
                right[stack.peek()] = i;
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    //    暴力解法 枚举高 中间扩散找范围 超时
    public static int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int high = heights[i];
            int left = i, right = i;

            while (left > 0 && heights[left - 1] >= high) {
                left--;
            }

            while (right < n - 1 && heights[right + 1] >= high) {
                right++;
            }
            ans = Math.max(ans, (right - left + 1) * high);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] height = new int[]{2, 1, 5, 6, 2, 3};

        System.out.println(largestRectangleArea(height));
        System.out.println(largestRectangleArea1(height));
        System.out.println(largestRectangleArea2(height));
        System.out.println(largestRectangleArea3(height));


    }

}
