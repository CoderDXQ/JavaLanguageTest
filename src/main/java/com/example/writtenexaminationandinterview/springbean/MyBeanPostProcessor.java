package com.example.writtenexaminationandinterview.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/19 6:32 下午
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行修改！");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行修改！");
        return bean;
    }
}
