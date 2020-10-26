package com.example.javalanguaguetest.stringbuilder;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/26 9:43 下午
 */
public class StringBuilderTest {
    public static void main(String[] args) {

        String[] st = {
                "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf",
                "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf",
                "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf",
                "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf",
                "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf",
                "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf",
                "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf",
                "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf",
                "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf", "sfvsdf"
        };

        long start, end;

        //  System.gc();

        start = System.currentTimeMillis();
        //使用StringBuilder进行优化的方法，避免产生大量无用对象
        explicitUseStringBuilder(st);
        System.gc();
        end = System.currentTimeMillis();
        System.out.println(end - start);


        start = System.currentTimeMillis();
        //不使用StringBuilder进行优化，不考虑字符串拼接的具体过程，会产生大量无用对象
        implicitUseStringBuilder(st);
        System.gc();
        end = System.currentTimeMillis();
        System.out.println(end - start);


    }

    public static void implicitUseStringBuilder(String[] values) {
        String result = "";
        for (int i = 0; i < values.length; i++) {
            //每次拼接都会产生新对象  产生values[i]的字符串对象，然后调用StringBuilder进行拼接，然后产生values[i]+result的拼接结果的新对象，然后把索引给result
            result += values[i];
        }
        //    System.out.println(result);R

    }

    public static void explicitUseStringBuilder(String[] values) {
        //使用StringBuilder对象拼接字符串不会产生新对象
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            //每次直接进行拼接，不用产生新对象
            result.append(values[i]);
        }
    }

}
