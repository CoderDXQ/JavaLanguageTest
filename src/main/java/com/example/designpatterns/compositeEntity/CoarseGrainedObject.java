package com.example.designpatterns.compositeEntity;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 9:50 下午
 */
//粗粒度对象
public class CoarseGrainedObject {

    DependentObject1 d1 = new DependentObject1();
    DependentObject2 d2 = new DependentObject2();

    public void setData(String data1, String data2) {
        d1.setData(data1);
        d2.setData(data2);
    }

    public String[] getData() {
        return new String[]{d1.getData(), d2.getData()};
    }

}
