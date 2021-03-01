package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/1 7:22 下午
 */
public class JZ11 {

    //    右移
    public static int NumberOf11(int n) {
//        无符号右移  如果是有符号右移当n为负数时不行
        int count = 0;
        while (n != 0) {
//            count += n & 1;
            if ((n & 1) == 1) {
                count++;
            }

//            有符号右移
//            n=n>>1;
//            无符号右移
            n = n >>> 1;
        }
        return count;
    }


    //    左移 每次都要移动32位
    public static int NumberOf12(int n) {
        int flag = 1;
        int count = 0;
//        利用位运算，flag会从右往左逐个检测n的二进制表示中的所有位数
        while (flag != 0) {
//            这个与运算的结果不一定是1
            if ((flag & n) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }


    //     位运算
    public static int NumberOf1(int n) {
        int count = 0;
//        一个整数与比它小1的数做与运算 会把这个整数最右边的1变为0 因此 当这个数变为0时的计算次数就是原来数的二进制表示中的1的个数
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
//        正数负数都要试试
        System.out.println(NumberOf11(10));
        System.out.println(NumberOf11(-10));
        System.out.println();

        System.out.println(NumberOf12(10));
        System.out.println(NumberOf12(-10));
        System.out.println();

        System.out.println(NumberOf1(10));
        System.out.println(NumberOf1(-10));
        System.out.println();

    }
}
