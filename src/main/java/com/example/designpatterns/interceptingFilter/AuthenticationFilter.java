package com.example.designpatterns.interceptingFilter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/17 12:11 上午
 */
//权限认证过滤器
public class AuthenticationFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}
