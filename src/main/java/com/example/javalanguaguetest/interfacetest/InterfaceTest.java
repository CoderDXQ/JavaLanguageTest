package com.example.javalanguaguetest.interfacetest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/29 11:06 下午
 */
interface in1 {
    final int a = 10;

    void display();
    // void hah();
}

public class InterfaceTest implements in1 {

    //接口中定义的方法都要在实现类中挨个实现
    public void display() {
        System.out.println("Implements in1");
    }

    public static void main(String[] args) {
        InterfaceTest t = new InterfaceTest();
        t.display();
        //实现接口的同时会拥有接口的成员变量
        System.out.println(a);
    }
}
