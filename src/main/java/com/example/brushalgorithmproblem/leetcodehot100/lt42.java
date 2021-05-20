package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 10:44 下午
 */
//接雨水
public class lt42 {

    //    动态规划
    public static int trap(int[] height) {

        return 0;
    }

    //    单调栈
    public static int trap1(int[] height) {

        return 0;
    }

    //    双指针
    public static int trap2(int[] height) {

        return 0;
    }

    //    按高度走 按行求
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
            ans += Math.max(maxLeft, maxRight) - height[i];

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
