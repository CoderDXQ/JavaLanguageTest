package com.example.bishimianshi.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 10:07 上午
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(18686);

        Socket socket = serverSocket.accept();
        ;

        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];

        int len = 0;

        while ((len = inputStream.read(bytes)) > 0) {
            System.out.println(new String(bytes, 0, len));
        }

        inputStream.close();
        socket.close();
        serverSocket.close();

    }

}
