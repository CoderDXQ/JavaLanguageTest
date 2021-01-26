package com.example.javalanguaguetest.reflection.classtest.forNameTest1;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/27 1:19 上午
 */
public class ClassTest {
    public static void main(String[] args) {
        try {

//            返回的是个类 不是个对象 会执行静态代码块（这个过程叫解释），但是不会执行构造函数，也就是说不会进行初始化
            Class userClass = Class.forName("com.example.javalanguaguetest.reflection.classtest.forNameTest1.User");
            System.out.println("userClass=" + userClass);

//            生成的是个对象  相当于new User() 不走静态代码块但是执行构造函数
            System.out.println();
            User user = (User) userClass.newInstance();
            System.out.println("user=" + user);

//            同上
            System.out.println();
            User user1 = new User();
            System.out.println("user1=" + user1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
