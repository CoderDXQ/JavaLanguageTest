package com.example.designpatterns.adapter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/20 7:33 下午
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
