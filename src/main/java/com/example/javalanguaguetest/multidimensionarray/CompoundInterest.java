package com.example.javalanguaguetest.multidimensionarray;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/12 7:36 下午
 * <p>
 * <p>
 * 该程序是计算不同利率下的投资增长情况
 * 输出结果第一行是利率
 * 从第二行开始，每一列从上往下是存款时间下的本金+利息
 */
public class CompoundInterest {
    public static void main(String[] args) {
        //初始利率十个点
        final double STARTRATE = 10;
        //利率六级增长，每级一个百分点
        final int NRATES = 6;
        //投资年限：10年
        final int NYEARS = 10;

        //计算各级利率 逐级利率增加一个点
        double[] intersetRate = new double[NRATES];
        for (int j = 0; j < intersetRate.length; j++)
            intersetRate[j] = (STARTRATE + j) / 100.0;

        //定义计算结果
        double[][] blances = new double[NYEARS][NRATES];

        //初始化各级利率第一年的本金
        for (int j = 0; j < blances[0].length; j++)
            blances[0][j] = 10000;

        for (int i = 1; i < blances.length; i++) {
            for (int j = 0; j < blances[i].length; j++) {
                double oldBalance = blances[i - 1][j];

                double interest = oldBalance * intersetRate[j];

                blances[i][j] = oldBalance + interest;
            }
        }

        //输出
        //输出计算的各级利率
        for (int j = 0; j < intersetRate.length; j++)
            //自定义输出格式需要使用printf 9位数字加上一个转换字符的%
            System.out.printf("%9.0f%%", 100 * intersetRate[j]);
        System.out.println();

        //输出投资计算结果表
        for (double[] row : blances) {
            for (double b : row)
                //自定义输出格式需要使用printf 一共十位数字，其中包含一个小数点和两位小数
                System.out.printf("%10.2f", b);
            System.out.println();
        }

    }
}
