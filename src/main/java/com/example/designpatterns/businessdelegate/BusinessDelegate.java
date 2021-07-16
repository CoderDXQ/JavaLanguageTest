package com.example.designpatterns.businessdelegate;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 9:30 下午
 */
//业务代表
public class BusinessDelegate {
    private BusinessLookUp lookUp = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    //    业务代表履行服务
    public void doTask() {
//        获取具体的服务提供者
        businessService = lookUp.getBusinessService(serviceType);
//        服务提供者提供信息
        businessService.doProcessing();
    }

}
