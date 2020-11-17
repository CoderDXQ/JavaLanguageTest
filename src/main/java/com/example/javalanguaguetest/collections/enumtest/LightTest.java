package com.example.javalanguaguetest.collections.enumtest;

import java.util.EnumSet;



public class LightTest {

    //定义枚举类型
    public enum Light {

        //利用构造函数传参
        RED(1), GREEN(3), YELLOW(2);

        //定义私有成员变量，下面重写的toString方法输出这个变量
        private int nCode;

        //构造函数，枚举类型的构造函数只能是私有
        private Light(int _nCode) {
            this.nCode = _nCode;
        }
//
//        @Override
//        public String toString() {
//            return String.valueOf(this.nCode);
//        }

    }

    public static void main(String[] args) {
        System.out.println("演示EnumSet对象的使用和遍历");
        testEnumSet();
    }

    public static void testEnumSet() {
        //allOf方法可以获取枚举类型所有的成员
        EnumSet<Light> currEnumSet = EnumSet.allOf(Light.class);
        for (Light aLightSetElement : currEnumSet) {
            //不重写toString方法的话，toString方法输出的是枚举类型成员的name
            System.out.println("当前EnumSet中的数据为：" + aLightSetElement);
        }

    }

}

