package com.example.datastructure.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/18 7:20 下午
 */
public class NIOServer {

    public static void main(String[] args) throws Exception {

//         获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

//        切换非阻塞模式
        serverSocketChannel.configureBlocking(false);

//        绑定连接 绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(9898));

//        获取选择器
        Selector selector = Selector.open();

        //将通道注册到选择器上 并且指定"监听接收事件"
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

//        轮询式的获取选择器上已经"准备就绪"的事件
        while (selector.select() > 0) {
//            获取当前选择器中所有注册的已经"准备就绪"的事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext()) {
//                获取准备就绪的事件
                SelectionKey sk = it.next();
//                判断具体是什么时间就绪
                if (sk.isAcceptable()) {

//                    若接收就绪 获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();

//                    切换非阻塞模式
                    socketChannel.configureBlocking(false);

//                    将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {

//                    获取当前选择器上"读就绪"状态的通道
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
//                    读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    int len = 0;
                    while ((len = socketChannel.read(buf)) > 0) {
//                        切换读写模式
                        buf.flip();
                        String str = new String(buf.array(), 0, len);
                        System.out.println("从客户端获取到消息：" + str);
                        buf.clear();
//                        关闭连接
                        if (str.endsWith("bye")) {
                            System.out.println("匹配了,关闭Server");
                            socketChannel.close();
                            serverSocketChannel.close();
                        }
                    }
                }
//                取消选择键
                it.remove();
            }
        }
    }
}
