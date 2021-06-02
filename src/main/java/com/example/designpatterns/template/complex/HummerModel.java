package com.example.designpatterns.template.complex;

/**
 * @author duanxiangqing
 * @date 2021/6/2
 */
//抽象类  负责声明 声明事物属性和方法  以及模板的流程
//    封装不变部分，扩展可变部分：把认为不变部分的算法封装到父类实现，可变部分则可以通过继承来实现，很容易扩展。
//提取公共部分代码，便于维护：上面悍马的例子就是个很好的解释。
//行为由父类控制，由子类实现。
public abstract class HummerModel {

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    //    加上final不允许被重写
    final public void run() {
        this.start();
        this.engineBoom();

        if (this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    protected boolean isAlarm() {
        return true;
    }


}
