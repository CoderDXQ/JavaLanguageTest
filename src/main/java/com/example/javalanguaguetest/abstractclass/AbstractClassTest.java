package com.example.javalanguaguetest.abstractclass;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/30 12:40 上午
 */
//抽象类animal
abstract class animal {
    private int age;

    public animal(int age) {
        this.age = age;
        System.out.println("初始化animal");
    }

    public void move() {
        System.out.println("跑步数：" + age);
    }
}

//dog类继承animal类
abstract class dog extends animal {
    public dog(int age) {
        super(age);
        System.out.println("初始化dog");
    }
}

public class AbstractClassTest extends dog {
    public AbstractClassTest() {
        super(10);//调用父类的构造方法
        System.out.println("初始化AbstractClassTest");
    }

    public static void main(String[] args) {
        AbstractClassTest a = new AbstractClassTest();
        a.move();
    }
}
