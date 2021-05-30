package com.example.brushalgorithmproblem;

/**
 * @author duanxiangqing
 * @date 2021/5/30
 */
//ST算法适用于区间查询  适用动态规划进行预处理 时间复杂度是O(nlogn) 查询时间复杂度
//这里计算区间最小值  稍加改动即可计算区间最大值
public class STAlgorithm {

    public static int[][] dp;

    public static void init(int[] array) {

//        初始化
        int len = array.length;
//        nlen是区间可能的数量  区间长度每次倍增  列的数量就是可能的区间长度的数量
        int nlen = (int) (Math.log(len) / Math.log(2));

        dp = new int[len * 2][nlen + 1];

        for (int i = 0; i < len; i++) {
            dp[i][0] = array[i];
        }

//        动态规划进行预处理
//        遍历区间长度从小到大
        for (int j = 1; j <= nlen; j++) {
//            遍历数组区区间最值
            for (int i = 0; i < len; i++) {
//                从子问题逐渐向上
                dp[i][j] = Math.min(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    public static int query(int[] array, int l, int r) {

//        计算可能的最大的区间长度
        int k = (int) (Math.log(r - l + 1) / Math.log(2));
//        可以用滑动窗口原理来理解这件事 找到最大的区间长度之后只需要比较首尾两个区间的最值即可
        return Math.min(dp[l][k], dp[r - (1 << k) + 1][k]);

    }

    public static void printdp() {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.printf("%5d", dp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int n = 10;
        int[] array = new int[n];

//        原始从小到大
//        for (int i = 0; i < 10; i++) {
//            array[i] = i;
//        }
//        原始从大到小
        for (int i = 0; i < 10; i++) {
            array[i] = 9 - i;
        }

//        预处理  原理是动态规划
        init(array);

        printdp();
        System.out.println();

//        进行查询
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                System.out.println("left: " + i + " , right: " + j + " ,value: " + query(array, i, j));
            }

        }


    }

}
