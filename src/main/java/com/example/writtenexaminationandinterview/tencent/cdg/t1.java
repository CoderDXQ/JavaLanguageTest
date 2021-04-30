package com.example.writtenexaminationandinterview.tencent.cdg;

import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/30 2:53 下午
 */
public class t1 {


    public static int[] merge(int[] array1, int[] array2) {

        int[] result = new int[array1.length + array2.length];

        int i = 0, j = 0, k = 0;

//        归并
        while (i < array1.length && j < array2.length) {

            if (k > 0 && array1[i] == result[k - 1]) {
                i++;
                continue;
            }

            if (k > 0 && array2[j] == result[k - 1]) {
                j++;
                continue;
            }

            if (array1[i] < array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

//        处理剩下的数据
        while (i < array1.length) {
            if (k > 0 && array1[i] == result[k - 1]) {
                i++;
                continue;
            }
            result[k++] = array1[i++];
        }

        while (j < array2.length) {
            if (k > 0 && array2[j] == result[k - 1]) {
                j++;
                continue;
            }
            result[k++] = array2[j++];
        }

        return Arrays.copyOf(result, k);
    }

    public static void main(String[] args) {

//        两个数组都是排好序的  输出结果要求无重复

//        按照入参的边界来设计测试用例
        int[] array1 = new int[]{1, 1, 2, 2, 3, 4, 4};
        int[] array2 = new int[]{1, 2, 2, 3};
//
//        int[] array1 = new int[]{1};
//        int[] array2 = new int[]{1};
//
//        无重复
//        int[] array1 = new int[]{1,2,3};
//        int[] array2 = new int[]{4,5,6};
//
//
//        int[] array1 = new int[]{1, 1, 2, 2, 3, 4, 4};
//        int[] array2 = new int[]{1, 2, 3};
//
//        存在空数组的情况
//        int[] array1 = new int[]{1, 2, 3};
//        int[] array2 = new int[]{};
//
//        int[] array1 = new int[]{};
//        int[] array2 = new int[]{1, 2, 3};
//
//        int[] array1 = new int[]{1, 1, 2, 2, 3, 4, 4};
//        int[] array2 = new int[]{};

//        int[] array1 = new int[]{};
//        int[] array2 = new int[]{};


//        相同
//        int[] array1 = new int[]{1, 2, 3};
//        int[] array2 = new int[]{1, 2, 3};

//        超长数组
//        int[] array1 = new int[]{1, 2, 3...........};
//        int[] array2 = new int[]{1, 2, 3...........};


        for (int i : merge(array1, array2)) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}
