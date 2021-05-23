package com.example.script;

public class NewParameterForWebDTS {


//    test case:
//    java -jar -Xms512m -Xmx1024m DTS.jar -ResultPath:/home/dtslinux/桌面/blankhead/ /home/dtslinux/DTSC_result/blankheadtest.db -Compiler:1 -Library:11111 -TestType:-R -DefectMode:1111 -BWList:/home/dtslinux/桌面/blacklist.txt -LogName:blankhead -3rdHeadPath:a/s/d

//    java -jar -Xms256m -Xmx512m NewParameter.jar -ResultPath:/home/dtslinux/桌面/blankhead/ /home/dtslinux/DTSC_result/blankheadtest.db -Compiler:1 -Library:11111 -TestType:-R -DefectMode:1111 -BWList:/home/dtslinux/桌面/blacklist.txt -LogName:blankhead -3rdHeadPath:a/s/d

//    启动命令
//    java  NewParameter -ResultPath:/home/dtslinux/桌面/blankhead/ /home/dtslinux/DTSC_result/blankheadtest.db -Compiler:1 -Library:11111 -TestType:-R -DefectMode:1111 -BWList:/home/dtslinux/桌面/blacklist.txt -LogName:blankhead -3rdHeadPath:a/s/d


//    必要字段都设置默认值就没有必要对命令行参数进行判断
//    if(start。。。){
//        throw new Exception("没有找到XX参数");
//    }


    /**
     * Linux上单机版的DTS与WebDTS的一些默认值的配置是不同的
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 先查找所有原来的文件中使用了args参数的地方
         * 然后挨个替换再测试一下
         */

//        使用其他变量替换原来的代码中直接使用的args参数

//        先设置默认最多15个参数 不够以后再加
        boolean[] flagOfArgs = new boolean[15];

        for (int i = 0; i < 15; i++) {
            flagOfArgs[i] = false;
        }

        for (String st : args) {
            if (st.startsWith("-TestProject:")) {//必要且没有默认值                8

                int start = st.indexOf(':');
                int end = st.length();
                if (start == -1) {
                    //从后台拿到
                } else {
                    NewArgs.setArgs8(st.substring(start, end));
                }

            } else if (st.startsWith("-ResultPath:")) {//必要但是设置默认值                     0
                int start = st.indexOf(':');
                int end = st.length();
                //???默认值
//                System.out.println(st.substring(start + 1, end));
                NewArgs.setArgs0(st.substring(start, end));
            } else if (st.startsWith("-Compiler:")) {//不必要 默认1                      1
                int start = st.indexOf(':');
                int end = st.length();
                //???默认值
//                System.out.println(st.substring(start + 1, end));
                NewArgs.setArgs0(st.substring(start, end));
            } else if (st.startsWith("-Library:")) {//不必要  后台自动添加                 2
                int start = st.indexOf(':');
                int end = st.length();
                //???默认值
//                System.out.println(st.substring(start + 1, end));
                NewArgs.setArgs0(st.substring(start, end));
            } else if (st.startsWith("-TestType:")) {//不必要  默认是源代码测试  默认值-R    3
                int start = st.indexOf(':');
                int end = st.length();
                //???默认值
//                System.out.println(st.substring(start + 1, end));
                NewArgs.setArgs0(st.substring(start, end));
            } else if (st.startsWith("-DefectMode:")) {//必要  默认值1111                 4
                int start = st.indexOf(':');
                int end = st.length();
                //???默认值
//                System.out.println(st.substring(start + 1, end));
                NewArgs.setArgs0(st.substring(start, end));
            } else if (st.startsWith("-BWList:")) {//必要 值从后台拿到                     5
                int start = st.indexOf(':');
                int end = st.length();
                //???默认值
//                System.out.println(st.substring(start + 1, end));
                NewArgs.setArgs0(st.substring(start, end));
            } else if (st.startsWith("-LogName:")) {//不必要  默认值是时间戳+文件名          6
                int start = st.indexOf(':');
                int end = st.length();
                //???默认值
//                System.out.println(st.substring(start + 1, end));
                NewArgs.setArgs0(st.substring(start, end));
            } else if (st.startsWith("-3rdHeadPath:")) {//必要  默认值为空                 7
                int start = st.indexOf(':');
                int end = st.length();
                //???默认值
//                System.out.println(st.substring(start + 1, end));
                NewArgs.setArgs0(st.substring(start, end));
            }
        }


        for (int i = 0; i < 10; i++) {
            System.out.println(NewArgs.get(i));
        }


    }

}
