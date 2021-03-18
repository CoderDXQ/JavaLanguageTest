package com.example.bishimianshi.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/18 9:12 上午
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
//        设置超时时间
        socket.setSoTimeout(3000);
//      设置连接的IP、端口、超时时间
        socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 2000), 3000);

        System.out.println("已发起连接服务");
        System.out.println("客户端信息：" + socket.getLocalSocketAddress() + " P:" + socket.getLocalPort());
        System.out.println("服务器信息：" + socket.getInetAddress() + " P:" + socket.getPort());

        try {
            todo(socket);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常退出");
        }
    }


    private static void todo(Socket client) throws Exception {

//        键盘输入流
        InputStream in = System.in;
        BufferedReader input = new BufferedReader(new InputStreamReader(in));
//        得到socket输出流并转换为打印流 信息来自客户端
        OutputStream outputStream = client.getOutputStream();
        PrintStream socketPrintStream = new PrintStream(outputStream);
//        得到socket输入流并转化为BufferedReader 信息来自服务器
        InputStream inputStream = client.getInputStream();
        BufferedReader socketBufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        Boolean flag = true;

        do {
//            从缓冲区读取一行
            String str = input.readLine();
//            发送到服务器
            socketPrintStream.println(str);
//            从服务器读取一行
            String echo = socketBufferedReader.readLine();
//            忽略大小写
            if ("bye".equalsIgnoreCase(echo)) {
                flag = false;
//                一般都是由客户端来请求断开连接
                System.out.println("客户端请求断开连接");
                System.out.println("服务器返回信息：" + echo);
            } else {
                System.out.println("服务器返回信息：" + echo);
            }
        } while (flag);
//        资源释放
        socketBufferedReader.close();
        socketPrintStream.close();

        client.close();

    }
}
