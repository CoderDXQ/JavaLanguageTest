package com.example.grpcdemo;

import com.example.justtest.GreeterGrpc;
import com.example.justtest.TestRequest;
import com.example.justtest.TestResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/12 11:34 下午
 */
public class TestClient {

    private final ManagedChannel channel;
    //    桩
    private final GreeterGrpc.GreeterBlockingStub blockingStub;
    private static final String host = "127.0.0.1";
    private static final int ip = 50051;


    //    关闭通道也能关闭客户端
    public TestClient(String host, int port) {
//        明文传输 不需要配置ssl
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
//        存根
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void testResult(String name) {
        TestRequest request = TestRequest.newBuilder().setName(name).build();
//        使用桩来进行rpc调用
        TestResponse response = blockingStub.testSomeThing(request);
        System.out.println(response.getMessage());
    }

    //    每次改完都重新从硬盘加载一下代码
    public static void main(String[] args) throws InterruptedException {
        TestClient client = new TestClient(host, ip);
        for (int i = 0; i <= 5; i++) {
            client.testResult("<<<<<result>>>>>:" + i);
        }

        System.out.println("关闭客户端");
        client.shutdown();

    }

}
