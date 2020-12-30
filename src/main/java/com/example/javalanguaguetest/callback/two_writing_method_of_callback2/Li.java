package com.example.javalanguaguetest.callback.two_writing_method_of_callback2;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/31 2:34 上午
 */
public class Li {

    public void executeMessage(int num) {
        System.out.println("小王要求的数字是：" + num);

//        模拟办事
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (i > 0 && i % 2 == 0) {
                count++;
            }
        }
        String result = "答案是" + count;

        callBack.solve(result);
    }

    public interface CallBack {
        void solve(String result);
    }

    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
