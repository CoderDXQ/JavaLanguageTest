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
//        原来匿名内部类的写法
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<Integer>(com);
    }

    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ys = new TreeSet<Integer>(com);
    }

}
