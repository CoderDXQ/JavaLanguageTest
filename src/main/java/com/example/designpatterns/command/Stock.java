package com.example.designpatterns.command;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 9:31 下午
 */
//请求类 功能的实现在这里面 后面会在命令实现类中实例化
//    后续如果需要新增命令只需要在这里面添加实现即可
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }

}
