package com.example.javalanguaguetest.reflection.genericessence;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/19 12:40 上午
 */

//使用反射研究集合泛型的本质
public class GenericEssence {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        List<String> list2 = new ArrayList<String>();

        list2.add("hello");
//        这一句会报错 list2规定了集合的唯一数据类型 添加其他类型的数据在编译期不会通过   这就是泛型检查
//        list2.add(20);
        System.out.println(list2);
        System.out.println("The size of list2 is : " + list2.size());


//        检查两者类型是否完全相同 二者是完全相同的
        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        System.out.println(c1 == c2);


//        如果一个类不存在 那么这个类就无法被反射到
        try {
//            使用反射得到add()方法
            Method m = c2.getMethod("add", Object.class);
//            调用方法 在运行期避免了进行泛型检查
            m.invoke(list2, 20);
            System.out.println(list2);
            System.out.println("The size of list2 is : " + list2.size());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
