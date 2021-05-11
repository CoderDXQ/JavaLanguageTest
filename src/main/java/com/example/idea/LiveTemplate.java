package com.example.idea;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanxiangqing
 * @date 2021/5/11
 */

//IDEA中的简写模板以及好用的插件
public class LiveTemplate {

    /**
     * 好用的插件:
     * GitToolBox 查看哪一行代码是谁写的
     * Auto filling java call arguments 方法参数自动补全
     * Rainbow Brackets 彩虹括号
     * CodeGlance 代码缩略图导航
     * Json Parser JSON解析器
     * Statistic 代码统计
     *
     * @param args
     */

//    psf
//    public static final

//    psfi
//    public static final int

//    psfs
//    public static final String


    /**
     * 展示常用的Live Template，当然也可以自定义Live Template
     *
     * @param args
     */
    public static void main(String[] args) {

//        sout
        System.out.println();

//        fori
        for (int i = 0; i < 5; i++) {

        }

//        iter
        for (String arg : args) {

        }

//        itar
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

        }

//        list.for
        List<String> list = new ArrayList<>();
        for (String s : list) {

        }

//        ifn
        if (list == null) {

        }

//        inn
        if (list != null) {

        }


    }


}
