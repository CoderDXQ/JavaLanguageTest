package com.example.designpatterns.businessdelegate;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 9:39 下午
 */
public class BusinessDelegatePatternDemo {
    public static void main(String[] args) {
//        创建业务代表
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

//        注入业务代表
        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();
    }
}
