package com.example.datastructure.queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/10 11:26 下午
 */
//使用数组实现队列
public class MyQueue<T> {

    private int capacity;
    private int front;
    private int tail;
    T[] data;

    public MyQueue(int capacity) {
        this.capacity = capacity + 1;
        this.front = 0;
        this.tail = 0;
        this.data = (T[]) new Object[capacity + 1];
    }

    public boolean isFull() {
        return (tail + 1) % capacity == front;
    }

    public boolean isEmpty() {
        return tail == front;
    }

    public void add(T t) {
        if (isFull()) {
            throw new RuntimeException("The Queue is Full!");
        } else {
            data[tail] = t;
//            使用取余操作实现循环
            tail = (tail + 1) % capacity;
        }
    }

    public T delete() {
        if (isEmpty()) {
            throw new RuntimeException("The Queue is Empty!");
        } else {
            T t = data[front];
            front = (front + 1) % capacity;
            return t;
        }
    }

    public int length() {
        return (tail + capacity - front) % capacity;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("The Queue is Empty!");
        } else {
            return data[front];
        }
    }

    public void showAllElements() {
        if (isEmpty()) {
            throw new RuntimeException("The Queue is Empty!");
        } else {
            for (int i = front; i < front + length(); i++) {
                System.out.print(data[i % capacity] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(3);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.showAllElements();

//        queue.add(4);

        System.out.println(queue.length());

        queue.delete();
        queue.delete();
        queue.delete();
//        queue.showAllElements();
        queue.add(4);
        queue.showAllElements();
        queue.delete();
//        queue.showAllElements();
        System.out.println(queue.length());

    }

}
