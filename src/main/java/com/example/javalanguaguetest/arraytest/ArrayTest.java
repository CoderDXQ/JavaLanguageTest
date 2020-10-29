package com.example.javalanguaguetest.arraytest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/29 6:50 下午
 */
public class ArrayTest {
    //从方法返回数组
    public static void main(String[] args) {
        int arr[] = m1();
        for (int x : arr) {
            System.out.println(x);
        }
        System.out.println("\n");
        //用于数组的类对象 定义时的两种写法
        int intArray[] = new int[3];
        byte byteArray[] = new byte[3];
        short shortArray[] = new short[3];
        String[] strArray = new String[3];

/*        字符串“[I”是类型为int的类对象“数组的运行时类型签名”。
        任何数组类型的唯一直接超类是java.lang.Object。
        字符串“[B”是类对象的运行时类型签名“组件类型为byte ”。
        字符串“[S”是组件类型为short的类对象的数组的运行时类型签名。
        字符串“[L”是组件类型为Class的类对象“数组的运行时类型签名”。类名称随后。*/
        System.out.println(intArray.getClass());
        System.out.println(intArray.getClass().getSuperclass());
        System.out.println(byteArray.getClass());
        System.out.println(shortArray.getClass());
        System.out.println(strArray.getClass());

        System.out.println("\n");
        //克隆数组
        int[] cloneArray = arr.clone();
        System.out.println("克隆一维数组时，新建数组而不是单纯的引用");
        System.out.println(cloneArray == arr);
        for (int x : cloneArray) {
            System.out.println(x);
        }

        System.out.println("\n");
        System.out.println("多维数组的克隆是一个浅拷贝，也就是说它只创建一个新数组，每个元素数组对一个原始元素数组的引用，但是子数组是共享的");
        int dualarr[][] = {{1, 2, 3}, {4, 5}};
        int[][] clonedualArray = dualarr.clone();
        System.out.println(dualarr == clonedualArray);
        System.out.println(dualarr[0] == clonedualArray[0]);
        System.out.println(dualarr[1] == clonedualArray[1]);


    }

    //从方法返回数组
    public static int[] m1() {
        return new int[]{1, 2, 3};
    }
}
