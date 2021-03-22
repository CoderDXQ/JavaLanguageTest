package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/22 12:14 下午
 */
//盛最多水的容器
public class lt11 {

    //    双指针    确定规则后才能使用双指针     没有规则不能保证无后效性的双指针移动规则是错误的
    public static int maxArea(int[] height) {
        int result = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int sum = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, sum);
//            移动比较短的板有可能产生新的最大的结果  但是移动比较高的板一定不会产生新的更大的值
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4, 3, 2, 1, 4};
        System.out.println(maxArea(height));
    }

}
