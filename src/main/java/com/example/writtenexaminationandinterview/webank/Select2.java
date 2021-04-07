package com.example.writtenexaminationandinterview.webank;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 9:07 下午
 */
public class Select2 {

    public static void main(String[] args) {
        int a = 6;
        int b = 0;

        try {
            System.out.println("start");
            a = a / b;
//            出错后被catch 不再执行下面这句
            System.out.println("try");
        } catch (ArithmeticException e) {
            System.out.println("Ar");
        } catch (Exception e) {
//            从上到下只能被catch一次 这里的被上面的劫走了
            System.out.println("Ex");
        }
        System.out.println("End");
    }
}
