package com.example.script;

import lombok.val;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/4 11:33 下午
 */
public class DealSelectIn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String arg = in.nextLine();
        System.out.println(deal(arg));
//        System.out.println(arg);
    }

    public static String deal(String arg) {

        int num = 0;
        for (int i = 0; i < arg.length(); i++) {
            if (arg.charAt(i) == '1') {
                num++;
            }
        }
        num--;
        System.out.println(num);

        String[] defect = {"Fault", "Rule", "Question", "Safety"};

        String sql = "select * from Scanset where Defect in (";
        for (int i = 0; i < arg.length(); i++) {
            if (arg.charAt(i) == '1') {
                sql += "'";
                sql += defect[i];
                sql += "'";
                if (num > 0) {
                    sql += ",";
                    num--;
                }
            }
        }

//        ???先不加分号
        sql += ")";
        return sql;
    }


}
