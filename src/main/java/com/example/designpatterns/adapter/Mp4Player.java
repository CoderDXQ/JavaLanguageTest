package com.example.designpatterns.adapter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/20 7:33 下午
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
