package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/1 5:25 下午
 */
//数值的整数次方
public class JZ12 {

    //    快速幂递归实现
    public static double Power1(double base, int exponent) {

        boolean flag = exponent < 0;
//        进来一次之后就永远为正了
        if (flag) {
            exponent = -exponent;
        }

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

//        当exponent为负数时，使用位运算会陷入死循环
        double result = Power1(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }

//        处理指数为负数的情况
        if (flag) {
//            利用位运算实现除以2
            return 1 / result;
        } else {
            return result;
        }
    }

    //    解耦
    public static double Power(double base, int exp) {
        boolean flag = exp < 0;
        if (flag) {
            exp = -exp;
        }
        double result = getPower(base, exp);
        return flag ? 1 / result : result;
    }

    public static double getPower(double base, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return base;
        }
        double ans = getPower(base, exp >> 1);
        ans *= ans;
        if ((exp & 1) == 1) {
            return ans * base;
        }
        return ans;
    }

    //    递推
    public static double Power2(double base, int exponent) {
//        指示指数的正负
        boolean flag = false;
        if (exponent < 0) {
            flag = true;
            exponent = -exponent;
        }

        double result = 1.0;
        while (exponent >= 1) {
            result *= result;
            if ((exponent & 1) == 1) {
                result *= base;
            }
            exponent >>= 1;
        }

        if (flag) {
            return 1 / result;
        }
        return result;
    }

    public static void main(String[] args) {
//        指数和基数都有可能为负数
        double base = -2.0;
        int exponent = -3;
//        System.out.println(Power(base, exponent));
//        System.out.println(Power1(base, exponent));
        System.out.println(Power2(base, exponent));
    }
}
