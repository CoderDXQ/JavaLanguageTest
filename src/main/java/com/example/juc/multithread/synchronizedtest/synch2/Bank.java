package com.example.juc.multithread.synchronizedtest.synch2;

import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/17 9:57 下午
 */
public class Bank {

    private final double[] accounts;

    //初始化银行账户
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    //加上synchronized关键字修饰
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        //账户余额就等待
        while (accounts[from] < amount)
            wait();
        //代码走到这里后说明账户余额充足
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance:%10.2f%n", getTotalBalance());
        //通知其他阻塞队列中的线程可以激活了
        notifyAll();
    }

    //加上synchronized关键字修饰
    //计算所有账户的总余额 如果不一样说明发生了错误
    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts)
            sum += a;
        return sum;
    }
    //返回账户数
    public int size() {
        return accounts.length;
    }
}
