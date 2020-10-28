package com.example.javalanguaguetest.thistest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/29 12:43 上午
 */

public class ThisTest {
    // 实例变量：num
    int num = 10;

    ThisTest() {
        System.out.println("This is an example program on keyword this");
    }

    ThisTest(int num) {
        // 调用默认构造方法
        this();

        // 将局部变量 num 分配给实例变量 num
        this.num = num;
    }

    public void greet() {
        System.out.println("Hi Welcome to Yiibai");
    }

    public void print() {
        // 局部变量：num
        int num = 20;

        // 打印局部变量
        System.out.println("value of local variable num is : " + num);

        // 打印实例变量
        System.out.println("value of instance variable num is : " + this.num);

        // 调用类方法
        this.greet();
    }

    public static void main(String[] args) {
        // 实例化该类
        ThisTest obj1 = new ThisTest();

        // 调用 print 方法
        obj1.print();

        //通过参数化构造函数将新值传递给 num 变量
        ThisTest obj2 = new ThisTest(30);

        // 再次调用 print 方法
        obj2.print();
    }
}
