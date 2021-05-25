package com.example.writtenexaminationandinterview.orderofclassload;

/**
 * @author duanxiangqing
 * @date 2021/5/25
 */
public class OrderOfClassLoad {

    public OrderOfClassLoad() {
        System.out.println("执行构造方法,只有在创建类时才会执行构造方法");
    }

    static {
        System.out.println("执行静态代码块，会在主方法之前执行");
    }

    {
        System.out.println("成员方法非静态，在构造方法之前执行");
    }


    public static void main(String[] args) {

        System.out.println("执行主方法");


        OrderOfClassLoad orderOfClassLoad = new OrderOfClassLoad();

    }


}
