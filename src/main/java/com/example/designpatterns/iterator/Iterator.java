package com.example.designpatterns.iterator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/11 11:44 下午
 */
//迭代器接口
public interface Iterator {
    public boolean hasNext();

    public Object next();
}
