package com.example.brushalgorithmproblem.swordtooffer;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 1:20 上午
 */
public class JZ48 {
    /**
     * 无进位和运算就是按位异或结果，进位就是与运算结果但是需要左移一位，因为进位影响下一位的运算。
     * 所以s = a + b,其实就是无进位和+进位的结果。
     * 算法步骤：
     * 计算a和b的无进位和，和进位
     * 如果进位不为0，则说明a+b的结果等于无进位和+进位，此时，把无进位和作为a，进位作为b，继续计算
     * 如果进位等于0， 说明此时a+b的结果就等于无进位和，返回无进位和即可。
     *
     * @param args
     */

//    非递归写法
    public static int Add(int num1, int num2) {

//        进位不为零就继续使用加法处理进位
        while (num2 != 0) {
            int carry = (num1 & num2) << 1;
            //        无进位和  num1头一次是num1和num2的无进位和 后来就是无进位和 和 和进位 求和
            num1 ^= num2;
//        和进位 需要把和进位再加上去
            num2 = carry;
        }

        return num1;
    }

    //    递归写法
    public static int Add1(int num1, int num2) {
        return num2 != 0 ? Add1(num1 ^ num2, (num1 & num2) << 1) : num1;
    }


    public static void main(String[] args) {
        System.out.println(Add(12, 16));
        System.out.println(Add1(12, 16));
    }
}
