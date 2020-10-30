package com.example.javalanguaguetest.tuplestest;
//需要使用maven导入org.javatuples库
//import javafx.util.Pair;

import org.javatuples.Pair;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/30 11:19 下午
 */
public class TuplesTest {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<Integer, String>(Integer.valueOf(1), "Geeks");

        pair = pair.setAt1("For");
        //pair=pair.setAt1("For");
    }

}
