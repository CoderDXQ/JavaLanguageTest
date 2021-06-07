package com.example.jdk8.methodreferences.factory;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 10:46 下午
 */
public class Test {

    public static void main(String[] args) {
//        使用Person类的构造方法重写PersonFactory类的create方法
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person.toString());
    }

}
