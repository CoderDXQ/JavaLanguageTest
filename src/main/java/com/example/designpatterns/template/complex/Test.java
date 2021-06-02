package com.example.designpatterns.template.complex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author duanxiangqing
 * @date 2021/6/2
 */
public class Test {


    public static void main(String[] args) throws IOException {

        System.out.println("----H1型悍马----");
        System.out.println("是否需要喇叭声响？ 0-不需要  1-需要");

        String type = new BufferedReader(new InputStreamReader(System.in)).readLine();

        HummerH1 h1 = new HummerH1();
        if (type.equals("0")) {
            h1.setAlarm(false);
        }

        h1.run();

    }

}
