package com.example.designpatterns.adapter;

import lombok.val;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/20 7:45 下午
 */
public class AdapterPatternDemo {
    /**
     * 一般情况下AudioPlayer只能播放MP3，这里使用适配器实现了播放vlc和mp4.
     * AudioPlayer
     *
     * @param args
     */
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
