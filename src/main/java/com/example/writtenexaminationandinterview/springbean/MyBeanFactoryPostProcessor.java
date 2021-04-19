package com.example.writtenexaminationandinterview.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/19 6:49 下午
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("这是BeanFactoryPostProcessor实现类构造器");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("person");
//        System.out.println("****************************");
//        System.out.println(bd.toString());
//        更改设置
        bd.getPropertyValues().addPropertyValue("phone", "110");

    }

}
