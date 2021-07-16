package com.example.designpatterns.frontController;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 11:50 下午
 */
public class FrontController {

    //    注入视图调度器
    private Dispatcher dispatcher;

    public FrontController() {
        this.dispatcher = new Dispatcher();
    }

    private boolean isAuthenticUser() {
        System.out.println("User is authenticated successfully.");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request) {
        trackRequest(request);
        if (isAuthenticUser()) {
            dispatcher.dispatch(request);
        }
    }

}
