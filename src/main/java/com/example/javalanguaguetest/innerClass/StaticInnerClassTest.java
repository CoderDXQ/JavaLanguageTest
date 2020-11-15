package com.example.javalanguaguetest.innerClass;

import com.sun.media.sound.SF2InstrumentRegion;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/15 10:40 下午
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }

        //用同一个类下的静态内部类的实力接这个类的返回值为静态内部类的内部方法
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min=" + p.getFirst());
        System.out.println("max=" + p.getSecond());
    }
}

class ArrayAlg {
    //静态内部类
    public static class Pair {
        private double first;
        private double second;

        public Pair(Double f, double s) {
            first = f;
            second = s;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

    }


    public static Pair minmax(double[] values) {

        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min, max);
    }
}
