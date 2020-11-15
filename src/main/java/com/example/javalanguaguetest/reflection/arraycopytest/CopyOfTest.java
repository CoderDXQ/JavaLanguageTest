package com.example.javalanguaguetest.reflection.arraycopytest;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/13 11:21 下午
 */

//两种
public class CopyOfTest {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        System.out.println();

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));
        System.out.println();

        System.out.println("The following call will generate an exception.");
        //父类向子类进行强制类型转换 编译时检测不出来但是运行时可以检测出来
        //badCopyOf()方法的返回值类型是Object[] 而负责接收的变量b是String[]
        //加上强制类型转换编译不会报错但是运行时会报错 不加强制类型转换编译会不通过
        b = (String[]) badCopyOf(b, 10);
        //System.out.println(b);
    }

    public static Object[] badCopyOf(Object[] a, int newLength) {
        //ComponentType是Object
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        //不管加不加强制类型转换 返回类型是Object 这是在方法的declare里写死的
        return newArray;
        //return (String[]) newArray;
    }

    public static Object goodCopyOf(Object a, int newLength) {

        //虽然是用Object接，但是ComponentType是不变的
        Class cl = a.getClass();

        //isArray()方法返回变量是不是一个Array
        if (!cl.isArray()) return null;

        //获取数组组件类型的Class
        Class componentType = cl.getComponentType();

        int length = Array.getLength(a);
        //新建一个实例 ComponentType并不是Object
        Object newArray = Array.newInstance(componentType, newLength);

        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        //返回的变量的ComponentType与传入时相同
        return newArray;
    }
}
