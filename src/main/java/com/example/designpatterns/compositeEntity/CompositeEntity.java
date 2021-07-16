package com.example.designpatterns.compositeEntity;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 9:52 下午
 */
//组合实体 组合实体调用粗粒度对象
public class CompositeEntity {
    private CoarseGrainedObject cgo = new CoarseGrainedObject();

    public void setData(String data1, String data2) {
        cgo.setData(data1, data2);
    }

    public String[] getData() {
        return cgo.getData();
    }

}
