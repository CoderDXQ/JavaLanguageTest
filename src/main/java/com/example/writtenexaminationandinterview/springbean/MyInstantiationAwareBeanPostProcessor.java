package com.example.writtenexaminationandinterview.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/19 6:38 下午
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！！");
    }

    //    实例化Bean之前调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessorAdapter调用postProcessBeforeInstantiation方法");

        return null;
    }

    //    实例化Bean之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessorAdapter调用postProcessAfterInstantiation方法");
        return bean;
    }

    //    设置某个属性时调用
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessorAdapter调用postProcessProperties方法");
        return pvs;
    }

    //    设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessorAdapter调用postProcessPropertyValues方法");
        return pvs;
//        return super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }
}
