package com.example.bishimianshi.webank;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 9:07 下午
 */
public class Select1 {

    public static String output = "";

    public static void main(String[] args) {
        Method(1);
        Method(2);
        System.out.println(output);
    }

    public static void Method(int i) {

        try {
            if (i == 1) {
                throw new Exception();
            }
//            i=1时不会执行这里
            output += "A";
        } catch (Exception e) {
//            catch异常之后直接指定完try catch finally就返回了
            output += "B";
//            return被finally覆盖失效
            return;
        } finally {
            output += "C";
        }
        output += "D";
    }

}
