package com.example.writtenexaminationandinterview.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用阻塞队列来实现生产者消费者模型
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/8 7:10 下午
 */
public class BlockingQueueTest {

    static class Producer implements Runnable {
        private BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
//                    Thread.sleep(new Random().nextInt(1000));
                    System.out.println("Send message : " + "Message: " + i);
                    queue.put("Message: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("Time to say goodbye!");
                queue.put("BYE");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        private BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String msg;
            try {
                while (!(msg = queue.take()).equals("BYE")) {
                    System.out.println("Consumed message: " + msg);
                }
                System.out.println("Get bye message, good bye!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

//        容量为3
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();

    }

}
