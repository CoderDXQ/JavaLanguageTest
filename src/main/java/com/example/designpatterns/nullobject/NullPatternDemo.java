package com.example.designpatterns.nullobject;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/13 11:29 下午
 */
public class NullPatternDemo {
    public static void main(String[] args) {
        AbstractCustomer customer1 = CustomFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomFactory.getCustomer("Laura");

        System.out.println("Customers : ");

        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }

}
