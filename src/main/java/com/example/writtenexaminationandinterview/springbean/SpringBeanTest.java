package com.example.writtenexaminationandinterview.springbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/19 5:26 下午
 */
//测试类
//参考：https://www.cnblogs.com/zrtqsk/p/3735273.html
public class SpringBeanTest {

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器");
//        配置文件都在resources文件夹中 传入的路径要弄好
        ApplicationContext factory = new ClassPathXmlApplicationContext("src/main/resources/beans.xml");

//        得到Person并开始使用
        Person person = factory.getBean("person", Person.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();

    }

}
