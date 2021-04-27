package com.example.writtenexaminationandinterview.redwars;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/27 10:41 上午
 */
//真实发抢红包模拟
public class DouRedWars1 {

    public static double sum = 0;

    static class Fa {

        private double money;
        private int person;

        private List<Double> list;

        public Fa(int person, double money) {
            this.money = money;
            this.person = person;
            list = Redwars.gen(person, money);
        }

    }


    static class Qiang implements Runnable {

        Fa fa;

        private List<Double> list;

        public Qiang(Fa fa) {
            list = fa.list;
        }

        @Override
        public synchronized void run() {
            if (list.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + "抢红包失败！");
            } else {
//                随机取数
                double num = list.remove(new Random().nextInt(list.size()));
                sum += num;
                System.out.println(Thread.currentThread().getName() + "抢到" + num + "元");
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {

        int person = 100;
        double money = 67.89;

        Fa fa = new Fa(person, money);

        for (int i = 0; i < 105; i++) {
            new Thread(new Qiang(fa)).start();
        }

        Thread.sleep(500);

        System.out.println("sum=" + sum);

    }


}
