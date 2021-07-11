package com.example.designpatterns.command;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 9:35 下午
 */
//某条命令的控制类
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
