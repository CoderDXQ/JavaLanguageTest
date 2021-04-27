package com.example.writtenexaminationandinterview.redwars;

import java.util.Random;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/27 10:30 上午
 */
//多线程抢红包
public class DouRedWars {

    static class User implements Runnable {

        private Bao bao;

        public User(Bao bao) {
            this.bao = bao;
        }

        @Override
        public void run() {

            double money = bao.getRandomMoney();
            if (money == 0) {
                System.out.println(Thread.currentThread().getName() + "不好意思，您手慢了");
            } else {
                System.out.println(Thread.currentThread().getName() + "抢到" + money + "元");
            }

        }

    }

    static class Bao {

        private double total;
        private int totalVal;
        private int count;

        public Bao(double total, int count) {
            this.total = total;
            this.count = count;
            this.totalVal = (int) (total * 100);
        }

        public synchronized double getRandomMoney() {

            int val = 0;

            if (count != 0 && totalVal / count == 1) {
                val = 1;
                totalVal -= val;
                count--;
                return val / 100;
            }

            if (count <= 0) {
                val = 0;
            } else if (count == 1) {
                val = totalVal;
            } else {
                int temp = 0;
                while (true) {
                    val = new Random().nextInt(totalVal / count);
                    temp = totalVal - val;
                    if (temp * 1.0 / (count - 1) >= 1 && val > 0) {
                        break;
                    }
                }
                totalVal -= val;
            }

            count--;
            return val / 100.0;

        }


    }


    public static void main(String[] args) {

        Bao bao = new Bao(10, 5);
        User user = new User(bao);

        for (int i = 0; i < 10; i++) {
            new Thread(user).start();
        }

    }


}
