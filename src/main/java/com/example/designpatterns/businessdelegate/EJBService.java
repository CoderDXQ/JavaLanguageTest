package com.example.designpatterns.businessdelegate;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 9:27 下午
 */
public class EJBService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
