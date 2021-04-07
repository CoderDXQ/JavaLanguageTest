package com.example.writtenexaminationandinterview.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 9:06 上午
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {

//        获取通道
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

//        切换非阻塞模式
        channel.configureBlocking(false);

//        分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

//        发送数据给服务端
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String str = scan.next();
            buffer.put(((new Date()).toString() + "\n" + str).getBytes());
            buffer.flip();
//            写入通道
            channel.write(buffer);
            buffer.clear();
        }

//        关闭通道
        channel.close();

    }

}
