package com.example.designpatterns.adapter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/20 7:30 下午
 */
//定义接口2 适配器的一方
public interface MediaPlayer {
    public void play(String audioType, String fileName);
}
