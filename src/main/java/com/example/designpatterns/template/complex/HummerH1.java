package com.example.designpatterns.template.complex;

/**
 * @author duanxiangqing
 * @date 2021/6/2
 */
public class HummerH1 extends HummerModel {

    private boolean alarmFlag = true;

    @Override
    protected void start() {
        System.out.println("H1发动");
    }

    @Override
    protected void stop() {
        System.out.println("H1停止");
    }

    @Override
    protected void alarm() {
        System.out.println("H1鸣笛");
    }

    @Override
    protected void engineBoom() {
        System.out.println("H1轰鸣");
    }

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    //    钩子函数 用于在外部改变状态
    public void setAlarm(boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }

}
