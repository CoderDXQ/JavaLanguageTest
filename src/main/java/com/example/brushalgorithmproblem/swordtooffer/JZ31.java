package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/12 11:43 下午
 */
public class JZ31 {

    //    抽象出数学计算模型 看不懂可以把下面的sout打开看看
    public static int NumberOf1Between1AndN_Solution(int n) {

        int sum = 0;
        int k = 1;

//        n=x+z+y
        int len = String.valueOf(n).length();
        for (int i = 0; i < len; i++) {
//            提取各数位
            int y = n % k;
            int x = n / (k * 10);
            int z = n % (k * 10) / k;

            if (z == 1) {
                sum = sum + x * k + y + 1;
            } else if (z == 0) {
                sum = sum + x * k;
            } else if (z > 1) {
                sum = sum + (1 + x) * k;
            }

//            System.out.println("x=" + x + " z=" + z + " y=" + y + " k=" + k);
            k = k * 10;
        }
        return sum;
    }


    //    转换成字符串计算
    public static int NumberOf1Between1AndN_Solution1(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            String st = String.valueOf(i);
            for (int j = 0; j < st.length(); j++) {
                if (st.charAt(j) == '1') {
                    sum++;
                }
            }
        }
        return sum;
    }

    //    利用求余和除法进行计算
    public static int NumberOf1Between1AndN_Solution2(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int s = i;
            while (s > 0) {
                if (s % 10 == 1) {
                    sum++;
                }
                s /= 10;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int n = 120120;

//        比较一下三种方法的运算时间
        Long start = System.currentTimeMillis();
        System.out.println(NumberOf1Between1AndN_Solution(n));
        System.out.println("Spending time: " + (System.currentTimeMillis() - start));
        System.out.println();

        start = System.currentTimeMillis();
        System.out.println(NumberOf1Between1AndN_Solution1(n));
        System.out.println("Spending time: " + (System.currentTimeMillis() - start));
        System.out.println();

        start = System.currentTimeMillis();
        System.out.println(NumberOf1Between1AndN_Solution2(n));
        System.out.println("Spending time: " + (System.currentTimeMillis() - start));
        System.out.println();

    }
}
