package com.example.designpatterns.template.simple;

import com.example.designpatterns.template.simple.ATemplate;
import com.example.designpatterns.template.simple.BusinessEntity;

/**
 * @author duanxiangqing
 * @date 2021/5/30
 */
public class Test {

    public static void main(String[] args) {

        ATemplate a = new BusinessEntity();

        a.templateMethod();

    }

}
