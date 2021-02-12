package com.example.juc.multithread.synchronizedtest.synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/17 9:57 下午
 */
public class Bank {

    private final double[] accounts;
    private Lock banklock;
    private Condition sufficientFunds;

    //初始化银行账户
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        //在初始化的同时生成锁 可重入锁
        banklock = new ReentrantLock();
        //条件对象  意思是余额充足
        sufficientFunds = banklock.newCondition();
    }

    //原来不加锁 不控制的转账方法
    //转账 由于没有对账户加锁 会导致多个账户同时向某个账号转账且该账户向其他账户转账的现象发生  因此产生数据错误
//    public void transfer(int from, int to, double amount) {
//        if (accounts[from] < amount) return;
//        System.out.print(Thread.currentThread());
//        accounts[from] -= amount;
//        System.out.printf(" %10.2f from %d to %d", amount, from, to);
//        accounts[to] += amount;
//        System.out.printf(" Total Balance:%10.2f%n", getTotalBalance());
//    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        //上锁
        banklock.lock();

        try {
            //余额不足就等待
            while (accounts[from] < amount)
                sufficientFunds.await();
            //代码走到这里后说明账户余额充足
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance:%10.2f%n", getTotalBalance());
            //通知其他线程锁被释放
            sufficientFunds.signalAll();
        } finally {
            //解锁
            banklock.unlock();
        }
    }

    //计算所有账户的总余额 如果不一样说明发生了错误
    public double getTotalBalance() {
        banklock.lock();
        try {
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
        } finally {
            banklock.unlock();
        }
    }

    //返回账户数
    public int size() {
        return accounts.length;
    }
}
