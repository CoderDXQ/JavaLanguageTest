package com.example.bishimianshi.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/18 9:29 上午
 */
public class Server {
    public static void main(String[] args) throws Exception {

//        设置端口号 建立server
        ServerSocket server = new ServerSocket(2000);
        System.out.println("服务器准备就绪");

//        输出服务器信息
        System.out.println("服务器信息：" + server.getLocalSocketAddress() + " P:" + server.getLocalPort());

//        轮训等待客户端连接
        for (; ; ) {
//            拿到客户端
            Socket client = server.accept();
//            启动一个异步线程来服务客户端
            ClientHandle clientHandle = new ClientHandle(client);
            clientHandle.start();
        }
    }

    private static class ClientHandle extends Thread {

        private Socket socket;
        private Boolean flag = true;

        public ClientHandle(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
//            输出客户端信息
            System.out.println("客户端连接：" + socket.getInetAddress() + " P:" + socket.getPort());

            try {

//                得到打印流 用于向客户端回送信息
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());

//                得到输入流 用于接收数据 拿的是client发来的消息
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                do {

                    String str = socketInput.readLine();
                    System.out.println("客户端传来信息：" + str);
//                    忽略大小写
                    if ("bye".equalsIgnoreCase(str)) {
                        flag = false;
                        socketOutput.println("bye");
                    } else {
                        System.out.println(str);
//                        回送的是客户端传来的数据长度
                        socketOutput.println("回送：" + str.length());
                    }
                }
                while (flag);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("异常断开");
            } finally {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭socket连接异常");
                }
            }
        }
    }
}
