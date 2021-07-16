package com.example.designpatterns.businessdelegate;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 9:28 下午
 */
//业务查询服务
public class BusinessLookUp {
    public BusinessService getBusinessService(String servectType) {
        if (servectType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}
