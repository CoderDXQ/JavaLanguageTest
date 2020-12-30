package com.example.javalanguaguetest.callback.two_writing_method_of_callback1;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/31 2:17 上午
 */
public class Wang implements CallBack {
    Li li;

    public Wang(Li li) {
        this.li = li;
    }

    //    异步方法，多个线程同时执行
    public void askQuestion(final int num) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.executeMessage(Wang.this, num);
            }
        }).start();
        goPlay();
    }

    private void goPlay() {
        System.out.println("问完问题，答案未知，玩去了。。。");
    }

    @Override
    public void solve(String result) {
        System.out.println("得到了答案: " + result);
    }
}
