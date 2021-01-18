package com.example.javalanguaguetest.reflection.crossObjectCheck;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/19 12:02 上午
 */
public class CrossObjectCheck {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        Class listClass = strList.getClass();
        //第二个参数是方法的形参类型
        Method m = listClass.getMethod("add", Object.class);

//        调用add()方法 泛型类用在编译期，编译后泛型擦除，所以可以使用反射越过泛型检查
//        越过泛型检查的目的是为了在同一个集合中添加其他数据类型的数据
        m.invoke(strList, 100);

        for (Object obj : strList) {
            System.out.println(obj);
        }

//        System.out.println();
//        Method[] ms = strList.getClass().getMethods();
//        for (Method mm : ms) {
//            System.out.println(m);
//        }
//
//        System.out.println();
//        Field[] fs = strList.getClass().getFields();
//        for (Field f : fs) {
//            System.out.println(f);
//        }

    }
}
