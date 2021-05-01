package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/4 1:47 上午
 */
//丑数
public class JZ33 {


    //    1也是丑数
    public static int GetUglyNumber_Solution(int index) {

        if (index == 0) {
            return 0;
        }

        int index_2 = 0, index_3 = 0, index_5 = 0, index_result = 1, min = Integer.MAX_VALUE;
        int[] num = new int[index + 1];
        num[0] = 1;
        for (int i = 1; i <= index; i++) {
            min = Math.min(Math.min(num[index_2] * 2, num[index_3] * 3), num[index_5] * 5);
            num[index_result++] = min;

//            下面这三句不一定只执行一句
            if (num[index_2] * 2 == min) {
                index_2++;
            }
            if (num[index_3] * 3 == min) {
                index_3++;
            }
            if (num[index_5] * 5 == min) {
                index_5++;
            }
        }

        return num[index_result - 1 - 1];

    }


    public static void main(String[] args) {

        System.out.println(GetUglyNumber_Solution(7));

    }


}
