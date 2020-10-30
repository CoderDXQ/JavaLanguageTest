package com.example.javalanguaguetest.abstractclass;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/30 10:02 上午
 */

abstract class Base {
    Base() {
        System.out.println("Base Constructor Called");
    }

    abstract void fun();

    //没有方法体就是抽象方法，必须有abstract修饰
    //抽象类中的final方法不需要被覆写
    final void test() {
        System.out.println("hi");
    }
}

class Derived extends Base {
    Derived() {
        System.out.println("Derived Constructor Called");
    }

    void fun() {
        System.out.println("Derived fun() C=called");
    }
}

public class AbstractClassTest1 {
    public static void main(String[] args) {
        Derived d = new Derived();
        d.fun();
        d.test();
    }
}
