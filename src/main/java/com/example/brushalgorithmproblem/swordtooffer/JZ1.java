package com.example.brushalgorithmproblem.swordtooffer;

import com.sun.source.tree.BinaryTree;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/11 4:48 下午
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&&tqId=11154&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
//二维数组中的查找
public class JZ1 {
    public static void main(String[] args) {
        int target = 102;
        int[][] array = {
                {1, 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 27, 30, 32, 35, 36, 38, 39, 42, 44, 46, 47, 48, 49, 51, 54, 55, 56},
                {23, 25, 31, 33, 35, 39, 42, 43, 44, 46, 50, 53, 56, 61, 62, 65, 68, 69, 72, 75, 78, 81, 82, 83, 88, 91, 92, 93, 96, 99},
                {26, 27, 33, 34, 38, 40, 45, 48, 51, 53, 55, 56, 58, 64, 66, 69, 72, 75, 77, 80, 82, 84, 87, 88, 90, 93, 94, 95, 99, 101},
                {29, 30, 36, 38, 40, 42, 47, 50, 53, 56, 57, 59, 62, 65, 68, 71, 73, 77, 79, 83, 84, 86, 88, 91, 93, 96, 99, 100, 102, 103},
                {32, 33, 39, 42, 44, 46, 49, 53, 56, 59, 62, 65, 68, 71, 72, 75, 77, 78, 80, 85, 87, 90, 92, 94, 96, 99, 101, 103, 105, 107}
        };

//        int[][] aa={{}};
//        System.out.println(aa.);
        Solution s1 = new Solution();
        //    s1.Find1(target, array);
        //  s1.Find2(target, array);
        s1.Find3(target, array);
//        s1.Find4(target, array);

    }

    /**
     * 第一种方法没有得到实现
     */
    public static class Solution {
        public boolean Find1(int target, int[][] array) {
            if (array == null) return false;

            /*从左上角往右下走的思路：
            1、不在向两个方向走的情况：走到最右下 或者 右边下边都大于此位置的数 或者 找到了返回true
            2、向右走：考虑回退的情况：下边的数小于此位置的数
            3、向下走：考虑回退的情况：右边的数小于此数
            这种方法的时间复杂度是n+n，极端情况大于n+n
            */

            // boolean ans=false;
            int i = 0, j = 0;
            while (i < array.length && j < array[0].length) {
                while (target > array[i][j] && target > array[i][j] && i + 1 < array.length && j + 1 < array[i].length) {
                    i++;
                    j++;
                }

                if (array[i][j - 1] == target || array[i - 1][j] == target || array[i][j] == target) {
                    System.out.println("true");
                    return true;
                }

                if (array[i][j - 1] > target && array[i - 1][j] > target) {
                    System.out.println("false");
                    return false;
                }

            }
            System.out.println("false");
            return false;

        }

        public boolean Find2(int target, int[][] array) {
            /*最优解法：从右上往左、下两个方向走。时间复杂度最大是n+m。从左下角走同理。
            好处：向左向下分别代表数值变化的两个方向。向下数值变大，向左数值变小。在这里就不需要考虑第一种方法里的回退情况。
            */
            if (array == null) return false;
//            排除array存在但为空的情况
            if (array[0].length == 0) return false;
            int i = 0, j = array[0].length - 1;
            while (i <= array.length - 1 && j >= 0) {
                if (target < array[i][j]) {
                    j--;
                } else if (target > array[i][j]) {
                    i++;
                } else if (target == array[i][j]) {
                    System.out.println("true");
                    return true;
                }
            }

            System.out.println("false");
            return false;
        }

        public boolean Find3(int target, int[][] array) {
            /*时间复杂度：n*logm
             * 在for循环中嵌套二分查找，有序数列就应该想到归并排序和二分查找
             * */
            if (array == null) return false;
            for (int i = 0; i < array.length; i++) {
                System.out.print("i=" + i);
                int left = 0;
                int right = array[i].length - 1;
                System.out.println(BinarySearch(target, array[i], left, right));
            }
            System.out.println("false");
            return false;
        }

//        public boolean BinarySearch(int target, int[] array, int left, int right) {
//        递归实现二分查找
//            int mid = (left + right) >> 1;
//            if (target < array[mid]) {
////                一定有等号
//                if (left >= mid) return false;
//                return BinarySearch(target, array, left, mid);
//
//            } else if (target == array[mid]) {
//                return true;
//            } else {
////                一定有等号
//                if (right <= mid + 1) return false;
//                return BinarySearch(target, array, mid + 1, right);
//            }
//        }

        public boolean BinarySearch(int target, int[] array, int left, int right) {
            int mid = (left + right) >> 1;
//            注意while循环的判断条件
            while (left <= right) {
                mid = (left + right) >> 1;
                if (array[mid] < target) {
                    left = mid + 1;
                } else if (array[mid] > target) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }

        public boolean Find4(int target, int[][] array) {
            /*方法二的递归实现
             * */
            if (array == null) return false;

            return recursion(target, array, 0, array[0].length - 1);
        }

        public boolean recursion(int target, int[][] array, int row, int column) {
            if (row >= array.length || column < 0) {
                System.out.println("false");
                return false;
            }
            if (target == array[row][column]) {
                System.out.println("true");
                return true;
            }
            if (target < array[row][column]) {
                //这里不能是column--
                return recursion(target, array, row, --column);
            } else {
                //这里不能是row++
                return recursion(target, array, ++row, column);
            }
        }
    }
}