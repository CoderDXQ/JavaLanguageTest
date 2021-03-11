package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 2:27 上午
 */
public class JZ49 {

    //直接利用Integer类的构造函数 捕获异常
    public static int StrToInt(String str) {
        int result = 0;
        try {
            result = new Integer(str);
//            利用报错处理异常结果
        } catch (NumberFormatException e) {
            return 0;
//            e.printStackTrace();
        }
        return result;
    }

    //正则表达式
    public static int StrToInt1(String str) {
//        使用long类型来包住Integer
        long result = 0;
//        正则表达式 检查字符串的格式
        if (!str.matches("[+,-]?\\d+")) {
            System.out.println("字符串格式错误: " + str);
            return 0;
        }

//        正负号
        int flag = str.charAt(0) == '-' ? -1 : 1;

        int len = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0;

        while (len <= str.length() - 1) {
            if (str.charAt(len) > '9' || str.charAt(len) < '0') {
                return 0;
            }
            result = result * 10 + str.charAt(len) - '0';
            len++;
        }

        result *= flag;

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            System.out.println("数据大小超出Integer的限制: " + str);
            return 0;
        }

        return (int) result;
    }

    //处理字符串
    public static int StrToInt2(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int result = 0;

        int flag = str.charAt(0) == '-' ? -1 : 1;

        int len = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0;

        while (len <= str.length() - 1) {
            if (str.charAt(len) > '9' || str.charAt(len) < '0' || ((result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && str.charAt(len) - '0' > 7)) && flag == 1) || (flag == -1 && ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && str.charAt(len) - '0' > 8)))) {
                return 0;
            }
            result = result * 10 + str.charAt(len) - '0';
            len++;
        }
        return flag * result;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("+2147483647"));
        System.out.println(StrToInt("-2147483648"));
        System.out.println(StrToInt("1a33"));
        System.out.println();

        System.out.println(StrToInt1("+2147483647"));
        System.out.println(StrToInt1("-2147483648"));
        System.out.println(StrToInt1("1a33"));
        System.out.println();

        System.out.println(StrToInt2("+2147483647"));
        System.out.println(StrToInt2("-2147483648"));
        System.out.println(StrToInt2("1a33"));
    }
}
