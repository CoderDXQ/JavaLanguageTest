package com.example.javalanguaguetest.reflection.objectanalyzer;

import java.util.ArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/13 3:11 下午
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        //Importance！！！
        //ArrayList的默认初始长度是10，因此输出结果最后会有几个null
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i <= 5; i++)
            squares.add(i * i);
        //打印数组 squares的长度并不是6，而是10，因此在输出结果的最后会有四个null
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
