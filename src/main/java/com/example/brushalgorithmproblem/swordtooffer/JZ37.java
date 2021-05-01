package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/30 1:48 上午
 */
//数字在排序数组中出现的次数
public class JZ37 {

    //    有问题就细分情况
    public int GetNumberOfK(int[] array, int k) {
        int mid;
        int leftbound, rightbound;

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if (array[left] == k) {
                leftbound = left;
                break;
            }
            mid = (left + right) >> 1;
            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else if (array[mid] == k) {
                leftbound = mid;
                right = mid;
            }
        }
        leftbound = left;

        left = 0;
        right = array.length - 1;
        while (left <= right) {
            if (array[right] == k) {
                rightbound = right;
                break;
            }
            mid = (left + right) >> 1;
            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else if (array[mid] == k) {
                rightbound = mid;
                left = mid;
            }
        }
        rightbound = right;

        return rightbound - leftbound + 1;
    }

    public static void main(String[] args) {
        JZ37 solution = new JZ37();
        int k = 3;
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(solution.GetNumberOfK(array, k));
    }
}
