package com.example.designpatterns.compositeEntity;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 9:56 下午
 */
public class CompositeEntityPatternDemo {
    public static void main(String[] args) {
        Client client = new Client();
        client.setData("Test", "Data");
        client.printData();
        client.setData("Second", "Num");
        client.printData();
    }
}
