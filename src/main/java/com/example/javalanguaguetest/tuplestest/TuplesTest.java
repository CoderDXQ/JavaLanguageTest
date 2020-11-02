package com.example.javalanguaguetest.tuplestest;
//需要使用maven导入org.javatuples库 这其实是个第三方库

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.javatuples.Pair;
import org.javatuples.Sextet;

import java.util.Objects;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/30 11:19 下午
 */
@Slf4j
public class TuplesTest {
    public static void main(String[] args) {
        //学习网址：https://github.com/sd4324530/JTuple
        Pair<Integer, String> pair = new Pair<Integer, String>(Integer.valueOf(1), "Geeks");

        Sextet<Integer, String, Integer, String, Integer, String> sextet
                = new Sextet<Integer, String, Integer, String, Integer, String>(
                Integer.valueOf(1), "Geeks",
                Integer.valueOf(2), "For",
                Integer.valueOf(3), "Geeks"
        );
        //花括号替换为逗号后面的内容
        //改变元组的值
        log.debug("show first:{}", pair);
        pair = pair.setAt1("For");
        log.debug("show:{}", pair);
        System.out.println("\n");

        //输出指定位置的元素 原来的first和second弃用了
        System.out.println("输出指定位置的元素");
        //输出时非字符串要用tostring()函数转化为字符串
        log.debug(pair.getValue(0).toString());
        log.debug(pair.getValue1());
        // log.debug(pair.toString());

        log.debug(sextet.toString());
        sextet = sextet.setAt0(5);
        log.debug(sextet.toString());

        //元组合并
        log.debug(pair.add(sextet).toString());

        Sextet<Integer, String, Integer, String, Integer, String> sextext
                = Sextet.with(Integer.valueOf(1), "Geeks",
                Integer.valueOf(2), "For",
                Integer.valueOf(3), "Geeks");

        //元组遍历
        sextext.forEach(o -> log.debug(Objects.toString(o)));

        System.out.println("\n");
        for (Object object : sextext) {
            log.debug(object.toString());
        }

    }

}
