package com.example.writtenexaminationandinterview.bianlifeng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/20 2:11 下午
 */
public class t1 {

    public static String[] arraySort(String[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j].compareTo(input[j + 1]) > 0) {
                    String temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        return input;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String strin = in.nextLine();
        String strout = in.next();

        String[] inin = strin.split(",");
        String[] outout = strout.split(",");

        HashMap<String, String> hashMapin = new HashMap<>();
        HashMap<String, String> hashMapout = new HashMap<>();

        for (String st : inin) {
            int location = st.indexOf('-');
            hashMapin.put(st.substring(0, location), st.substring(location + 1, st.length()));
        }

        for (String st : outout) {
            int location = st.indexOf('-');
            hashMapout.put(st.substring(0, location), st.substring(location + 1, st.length()));
        }

        ArrayList<String> listold = new ArrayList<>();
        for (String st : inin) {
            int location = st.indexOf('-');
            listold.add(st.substring(0, location));
        }

        ArrayList<String> listnew = new ArrayList<>();
        for (String st : outout) {
            int location = st.indexOf('-');
            listnew.add(st.substring(0, location));
        }


        ArrayList<String> result = new ArrayList<>();
//        遍历老数组并处理 比较过的就删除
        for (String key : listold) {
//            相等
            if (hashMapout.containsKey(key) && hashMapin.containsKey(key) && hashMapin.get(key).equals(hashMapout.get(key))) {
                hashMapin.remove(key);
                hashMapout.remove(key);
            }
//            修改
            if (hashMapout.containsKey(key) && hashMapin.containsKey(key) && hashMapin.get(key).equals(hashMapout.get(key)) == false) {
                result.add("modify-" + key);
                hashMapin.remove(key);
                hashMapout.remove(key);
            }
//            删除
            if (hashMapout.containsKey(key) == false && hashMapin.containsKey(key)) {
                result.add("delete-" + key);
                hashMapin.remove(key);
            }
        }

//        遍历新数组并处理 比较过的就删除 主要是找出新增的或者删除的
        for (String key : listnew) {
//            新增
            if (hashMapin.containsKey(key) == false && hashMapout.containsKey(key)) {
                result.add("add-" + key);
                hashMapout.remove(key);
            }
        }


        String[] paixv = new String[result.size()];
        int k = 0;
        for (String st : result) {
            paixv[k++] = st;
        }

        paixv = arraySort(paixv);

        for (int i = 0; i < paixv.length - 1; i++) {
            System.out.print(paixv[i] + ",");
        }
        System.out.println(paixv[paixv.length - 1]);


    }
}
