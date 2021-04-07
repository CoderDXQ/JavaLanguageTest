package com.example.writtenexaminationandinterview.nio;

import java.io.IOException;
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
 * @date 2021/4/7 9:06 上午
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {
//        获取通道
        ServerSocketChannel channel = ServerSocketChannel.open();
//        切换非阻塞模式
        channel.configureBlocking(false);

//        绑定连接 绑定到端口号
        channel.bind(new InetSocketAddress(9898));

//        获取选择器
        Selector selector = Selector.open();

//        将通道注册到选择器上，并且指定"监听接收事件"
        channel.register(selector, SelectionKey.OP_ACCEPT);

//        轮询式的获取选择器上已经"准备就绪"的事件   这是NIO的缺点 轮询的方式会导致cpu被打满
        while (selector.select() > 0) {//说明至少有一个准备就绪了

//            获取当前选择器上所有注册的选择键(已就绪事件)
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext()) {
//                获取准备就绪的事件
                SelectionKey sk = it.next();

//                判断事件类型
//                接收就绪
                if (sk.isAcceptable()) {
//                    获取客户端连接
                    SocketChannel socketChannel = channel.accept();
//                    切换非阻塞模式
                    socketChannel.configureBlocking(false);
//                    将通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
//                    获取当前选择器上"读就绪"状态的通道
                    SocketChannel socketChannel = (SocketChannel) sk.channel();

//                    读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int len = 0;
                    while ((len = socketChannel.read(buffer)) > 0) {

                        System.out.println("数据长度：" + len);
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();

                    }
                }
//                取消选择键 SelectionKey
                it.remove();
            }
        }

    }

}
