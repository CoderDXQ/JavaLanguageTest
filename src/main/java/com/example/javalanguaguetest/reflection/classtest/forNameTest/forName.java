package com.example.javalanguaguetest.reflection.classtest.forNameTest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/26 11:29 下午
 */

//newInstance()方法可以进行实例化  forName()方法只是进行加载和连接
public class forName {
    public static void main(String[] args) {
        String user = "com.example.javalanguaguetest.reflection.forname.forNameTest.User";
        test(user);

    }

    public static void test(String user) {
//        System.out.println(user);
        try {

//            测试loadClass()方法
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            System.out.println("classloader testing...");
//            只进行加载，不执行静态代码块的内容  返回的是个类名
            Class<?> loaderUser = loader.loadClass(user);
            System.out.println("user " + loaderUser.getName());
            System.out.println("---------------------------------");


//            测试forName()方法
//            执行下一句的时候会执行静态代码块的内容（这个过程叫解释）
            Class forNameUser = Class.forName(user);
            System.out.println("Class.forName testing...");
            System.out.println("user " + forNameUser.getName());
            System.out.println("---------------------------------");


//            测试newInstance()方法 必须要加强制类型转换
//            会额外执行普通代码块
            User user1 = (User) forNameUser.newInstance();
            System.out.println("newInstance() method testing");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
