package com.example.writtenexaminationandinterview.sss;

import java.util.concurrent.CountDownLatch;

/**
 * @author duanxiangqing
 * @date 2021/5/25
 */
//验证StringBuilder线程不安全
public class TestThredSafety1 {

    public static void main(String[] args) throws InterruptedException {

        StringBuilder sbd = new StringBuilder("0000011111");

        CountDownLatch countDownLatch1 = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            new Thread(new MyThreadOfStringBuilder(sbd, countDownLatch1)).start();
        }

        countDownLatch1.await();
//        多线程翻转会产生错误 这里的reverse()方法不是原子性的
        System.out.println(sbd);


        CountDownLatch countDownLatch2 = new CountDownLatch(100);

        StringBuffer sbf = new StringBuffer("0000011111");

        for (int i = 0; i < 100; i++) {
            new Thread(new MyThreadOfStringBuffer(sbf, countDownLatch2)).start();
        }
        countDownLatch2.await();
//        这里的reverse()方法是原子性的 因为加了synchronized
        System.out.println(sbf);

    }

    private static class MyThreadOfStringBuilder implements Runnable {

        private StringBuilder sb;
        private CountDownLatch countDownLatch;

        public MyThreadOfStringBuilder(StringBuilder sb, CountDownLatch countDownLatch) {
            this.sb = sb;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            for (int i = 0; i < 100; i++) {
                sb.reverse();
                countDownLatch.countDown();
            }
//            System.out.println(sb);
        }

    }

    private static class MyThreadOfStringBuffer implements Runnable {

        private StringBuffer sb;
        private CountDownLatch countDownLatch;

        public MyThreadOfStringBuffer(StringBuffer sb, CountDownLatch countDownLatch) {
            this.sb = sb;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            for (int i = 0; i < 100; i++) {
                sb.reverse();
                countDownLatch.countDown();
            }
//            System.out.println(sb);
        }

    }

}
