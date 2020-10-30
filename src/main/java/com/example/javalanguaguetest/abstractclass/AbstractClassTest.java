package com.example.javalanguaguetest.abstractclass;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/30 12:40 上午
 */

//抽象类不能实例化，抽象类必须被继承
//抽象方法必须为public、protected，如果是private那就不能被子类继承
//一个类只能继承一个抽象类，但是一个类可以实现多个接口
//当一个对象获得父对象的所有属性和行为时，称为继承。它提供代码可重用性，它用于实现运行时多态性。被继承的类称为超类，继承超类的类称为子类
//继承抽象类的子类必须覆写抽象类中所有的抽象方法，如果子类没有实现父类的抽象方法，必须将子类也定义为abstract类。
//抽象类animal
//如果一个子类包含抽象方法，那么该类必须是抽象类
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
        super(age);//调用父类的有参构造方法 子类的第一行必须有这一句
        System.out.println("初始化dog");
    }
}

public class AbstractClassTest extends dog {
    public AbstractClassTest() {
        super(10);//调用父类的有参构造方法 子类的第一行必须有这一句
        System.out.println("初始化AbstractClassTest");
    }

    public static void main(String[] args) {
        AbstractClassTest a = new AbstractClassTest();
        a.move();
    }
}
