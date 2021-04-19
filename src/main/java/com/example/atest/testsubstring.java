package com.example.atest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/20 1:06 上午
 */
public class testsubstring {

    public static void main(String[] args) {
        String st = "afsaf";
        while (st.length() > 0) {
//            只传入开始的下标，那么结尾的下标默认到最后
            st = st.substring(1);
            System.out.println(st);
        }
    }

}
