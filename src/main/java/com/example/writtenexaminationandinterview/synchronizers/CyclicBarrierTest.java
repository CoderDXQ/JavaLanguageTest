package com.example.writtenexaminationandinterview.synchronizers;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CountDownLatch实现并行计算
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/9 8:57 上午
 */
public class CyclicBarrierTest {

    static class Student implements Runnable {
        private CyclicBarrier barrier;
        private String name;

        public Student(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
                Random random = new Random();

                Thread.sleep(random.nextInt(3000));
                System.out.println(sdf.format(new Date()) + " " + name + "出发去饭店");
                Thread.sleep(random.nextInt(3000));
                System.out.println(sdf.format(new Date()) + " " + name + "到了饭店");

//                等到barrier增加到设定的数值之后再向下执行
                barrier.await();
//                barrier.wait();

                System.out.println(sdf.format(new Date()) + " " + name + "开始吃饭");
                Thread.sleep(random.nextInt(3000));
                System.out.println(sdf.format(new Date()) + " " + name + "吃完了");

//            重用
                barrier.await();
//                barrier.wait();

                System.out.println(sdf.format(new Date()) + " " + name + "离开餐厅");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(3);

        List<Thread> threads = new ArrayList<>(3);
        threads.add(new Thread(new Student(barrier, "A")));
        threads.add(new Thread(new Student(barrier, "B")));
        threads.add(new Thread(new Student(barrier, "C")));

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }


    }

}
