package com.example.datastructure.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/18 7:20 下午
 */
public class NIOClient {

    public static void main(String[] args) throws Exception {

//        获取通道 先开服务端再开客户端
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

//        切换非阻塞模式
        socketChannel.configureBlocking(false);

//        分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

//        发送数据给服务端 从键盘获取数据
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String str = scan.next();
            System.out.println("即将发送信息：" + str);
//            将要发送的信息转换成字节 现在是读模式
            buf.put((new Date().toString() + "\n" + str).getBytes());
//            读写模式转换
            buf.flip();
//            往同通道中写入
            socketChannel.write(buf);
            System.out.println("发送信息：" + str);

//            关闭缓冲区
            buf.clear();
        }
//        关闭通道
        socketChannel.close();
    }
}
