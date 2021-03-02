package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/2 4:15 下午
 */
public class JZ19 {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
//        表示移动的方向数组
        int[] hang = new int[]{0, 1, 0, -1};
        int[] lie = new int[]{1, 0, -1, 0};
//        标记数组
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[i].length; j++) {
                flag[i][j] = false;
            }
        }

//        sum是已经加入结果队列的元素数 i,j是二维数组的坐标 k是移动数组的坐标
        int sum = 0, i = 0, j = 0, k = 0;
        while (sum < matrix.length * matrix[0].length) {

//            未被访问且未超界
            while (i < matrix.length && j < matrix[0].length && i >= 0 && j >= 0) {
                if (flag[i][j] == false) {
                    result.add(matrix[i][j]);
                    sum++;
                } else {
                    break;
                }
                flag[i][j] = true;
                i += hang[k];
                j += lie[k];
            }
//            方向数组的循环技巧
            i -= hang[k];
            j -= lie[k];
            k = (k + 1) % 4;
            i += hang[k];
            j += lie[k];
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

//        for (int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[0].length;j++){
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
        ArrayList<Integer> result = printMatrix(matrix);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }


}
