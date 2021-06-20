package com.example.designpatterns.adapter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/20 7:31 下午
 */
//定义接口1 适配器的一方
public interface AdvancedMediaPlayer {
    public void playVlc(String fileName);

    public void playMp4(String fileName);
}
