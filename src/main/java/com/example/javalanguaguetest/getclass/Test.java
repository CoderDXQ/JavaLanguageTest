package com.example.javalanguaguetest.getclass;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/15 5:23 下午
 */
public class Test {

    public static void main(String[] args) {
        GetClass p = new GetClass(1, "df");
        System.out.println(p.getClass());//getClass()方法获取调用该方法的对象的类
        System.out.println(GetClass.class);//得到类的全路径
        System.out.println(GetClass.class.getClass());//得到对象的类模板示例，也就是Class
        System.out.println(p.getClass().getName());//getClass().getName()获取该类的路径
        System.out.println(p.getClass().getSimpleName());//得到类的简写名称
        System.out.println(p.id);
    }
}
