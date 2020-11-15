package com.example.javalanguaguetest.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/15 10:31 下午
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        //interval间隔 beep哔哔声
        TalkingClock1 clock = new TalkingClock1();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock1 {

    public void start(int interval, boolean beep) {
        //匿名内部类
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone,the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };//这里是一个赋值语句进行实例化 使用匿名内部类来进行实例化
        Timer t = new Timer(interval, listener);
        t.start();
    }
}
