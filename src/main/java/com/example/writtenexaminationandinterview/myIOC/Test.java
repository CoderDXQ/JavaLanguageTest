package com.example.writtenexaminationandinterview.myIOC;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/19 10:30 下午
 */
public class Test {

    @org.junit.Test
    public void getBean() throws Exception {
//        不能有汉字 从编译后的文件中获取xml文件
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }

}
