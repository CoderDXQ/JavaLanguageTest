package com.example.writtenexaminationandinterview.redwars;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/26 11:40 下午
 */

//抢红包的几种算法
public class Redwars {

    //    二倍均值法
    public static List<Double> gen(int person, double money) {
        List<Double> list = new ArrayList<Double>();
        Random random = new Random();
//        最小单位是分
        int m = (int) (money * 100);
//        最后一个获得全部的余额
        while (person > 1) {
            int num = (int) random.nextInt(2 * (m / person));
//            注意是除以100.0而不是100
            list.add((double) (num / 100.0));
            m -= num;
            person--;
        }
//        最后一个红包
        list.add((double) (m / 100.0));
        return list;
    }

    //    线段法
    public static List<Double> gen1(int person, double money) {

        List<Double> packets = new ArrayList<>();
        Random random = new Random();
        Set<Double> points = new TreeSet<>();
//        生成线段上截取的点
        while (points.size() < person - 1) {
//            找到n-1个点 random.nextDouble()的作用是生成1以内的小数
            Double num = Math.round(random.nextDouble() * (money - 1) * 100) / 100.0;
            points.add(num);
        }

//        记录最后一个点
        points.add(money);
        Double propoint = 0d;
        for (Double point : points) {
//            Math.round()方法是取整
            Double num2 = Math.round((point - propoint) * 100) / 100.0;
            packets.add(num2);
            propoint = point;
        }

        return packets;

    }


    public static void main(String[] args) {

        int person = 10;
        double money = 67.89;

        double sum = 0;
        int num = 0;

        System.out.println("二倍均值算法：");
        for (Double d : gen(person, money)) {
            sum += d;
            num++;
            System.out.print(d + " ");
        }
        System.out.println();
        System.out.println("num=" + num);
        System.out.println("sum=" + sum);
        System.out.println();

        sum = 0;
        num = 0;
        System.out.println("线段算法：");
        for (Double d : gen1(person, money)) {
            sum += d;
            num++;
            System.out.print(d + " ");
        }
        System.out.println();
        System.out.println("num=" + num);
        System.out.println("sum=" + sum);
        System.out.println();


    }

}
