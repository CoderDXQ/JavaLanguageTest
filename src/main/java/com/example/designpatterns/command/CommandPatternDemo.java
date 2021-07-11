package com.example.designpatterns.command;

import lombok.val;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 9:43 下午
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
//        所有命令的具体实现都在Stock
        Stock abcStock = new Stock();

//        注入Stock才能使Order接口类的实现类控制Stock中某个命令的具体实现
        BuyStock buyStock = new BuyStock(abcStock);
        SellStock sellStock = new SellStock(abcStock);

//        调度命令执行 这里类似于批处理
        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrders();

    }
}
