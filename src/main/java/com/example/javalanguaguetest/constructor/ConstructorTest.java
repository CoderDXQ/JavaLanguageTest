package com.example.javalanguaguetest.constructor;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/29 9:33 下午
 */
public class ConstructorTest {
    //构造函数不能使用abstract、final、static、synchronized修饰
    //构造函数不能有返回值，构造函数不是方法
    //构造函数只在Object被创建时调用一次，而方法的调用不受限制
    //构造函数重载
    public static void main(String[] args) {
        Geek geek1 = new Geek("dsfsdf");
        Geek geek2 = new Geek("sdgdsgds", 5);
        Geek geek3 = new Geek(89);

    }
}

class Geek {
    //重载构造函数
    Geek(String name) {
        System.out.println("Constructor with one " + "argument - String : " + name + " ");
    }

    Geek(String name, int age) {
        System.out.println("Constructor with two arguments : " +
                " String and Integer : " + name + " " + age);
    }

    Geek(long id) {
        System.out.println("Constructor with one argument : " +
                "Long : " + id);
    }
}
