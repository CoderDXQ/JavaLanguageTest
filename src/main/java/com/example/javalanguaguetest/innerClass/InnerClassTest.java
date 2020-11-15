package com.example.javalanguaguetest.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/15 10:01 下午
 */
public class InnerClassTest {
    public static void main(String[] args) {
        //interval间隔 beep哔哔声
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock {

    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    //重写start()方法
    public void start() {
        //实例化内部类
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    //用一个类实现接口 这是内部类的一种形式
    public class TimePrinter implements ActionListener {
        //重写方法
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone,the time is " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
