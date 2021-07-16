package com.example.designpatterns.compositeEntity;

import com.sun.javaws.IconUtil;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 9:54 下午
 */
//客户端接收请求并分发给组合实体
public class Client {
    private CompositeEntity compositeEntity = new CompositeEntity();

    public void printData() {
        for (int i = 0; i < compositeEntity.getData().length; i++) {
            System.out.println("Data : " + compositeEntity.getData()[i]);
        }
    }

    public void setData(String data1, String data2) {
        compositeEntity.setData(data1, data2);
    }

}
