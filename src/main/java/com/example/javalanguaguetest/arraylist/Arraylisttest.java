package com.example.javalanguaguetest.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/14 1:13 上午
 */
public class Arraylisttest {

    public static void main(String[] args) {

//        List list;//正确，list = null;
//
//        List list = new List();//是错误的用法
//
//        List list = new ArrayList();这句创建了一个ArrayList实现类的对象后把它上溯到了List接口。此时它就是一个List对
//
//        象了，有些ArrayList类具有的但是List接口没有的属性和方法就不能再用了。 而ArrayList list=new ArrayList();
//
//        创建一对象则保留了ArrayList的所有属性和方法。
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("王利虎");
        list.add("李四");

        int size = list.size();
        System.out.println(size);

        String[] array = (String[]) list.toArray(new String[size]);//将list转化为数组
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
