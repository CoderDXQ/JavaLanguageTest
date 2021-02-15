package com.example.jdk8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/12 1:46 下午
 */
public class LambdaTest {

    @Test
    public void test1() {
//        原来匿名内部类的写法 一个比较类
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
//TreeSet是一个有序的SET集合 在com中定义了排序(比较)规则
        TreeSet<Integer> ts = new TreeSet<Integer>(com);
    }

    //使用lambda表达式的匿名内部类的写法
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ys = new TreeSet<Integer>(com);
    }

}
