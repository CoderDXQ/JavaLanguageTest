package com.example.javalanguaguetest.generics;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/3 3:18 下午
 */

//单个参数类型的泛型类
class Test<T> {
    T obj;

    Test(T obj) {//构造函数
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }
}

//多个参数类型的泛型类
class Testt<T, U> {
    T obj1;
    U obj2;

    Testt(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void print() {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}

public class GenericsTest {

    //泛型函数
    static <T> void genericsDisplay(T element) {
        //展示数据类型的类的名称和传入的参数的数值
        System.out.println(element.getClass().getName() + " = " + element);
    }


    public static void main(String[] args) {
        //菱形内是具体的数据类型
        Test<Integer> iobj = new Test<Integer>(16);
        System.out.println(iobj.getObj());

        Test<String> sobj = new Test<String>("abc");
        System.out.println(sobj.getObj());

        System.out.println("\n");

        Testt<String, Integer> obj = new Testt<String, Integer>("dfg", 12);
        obj.print();

        System.out.println("\n");

        //调用泛型方法
        genericsDisplay(11);
        genericsDisplay("sf");
        genericsDisplay(8.9);


    }
}
