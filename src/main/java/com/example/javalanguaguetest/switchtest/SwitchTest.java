package com.example.javalanguaguetest.switchtest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/15 7:19 下午
 */
public class SwitchTest {

    public static void printName(Color color) {
        switch (color) {
            case RED:
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;

            case GREEN:
                System.out.println("绿色");
                break;

            default:
                System.out.println("上面一定要写break");

        }
    }

    public static void main(String[] args) {
        printName(Color.BLUE);
        printName(Color.GREEN);
        printName(Color.RED);

    }

}
