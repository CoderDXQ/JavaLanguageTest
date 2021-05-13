package com.example.grpcdemo;


import com.example.justtest.GreeterGrpc;
import com.example.justtest.TestRequest;
import com.example.justtest.TestResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/12 11:14 下午
 */
public class TestServer {

    //    端口
    private final int port = 50051;

    //    服务
    private Server server;

    //    启动服务
    private void start() throws IOException {
        server = ServerBuilder.forPort(port).addService(new GreeterImpl()).build().start();
        System.out.println("服务启动————————————");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("-------shutting down gRPC server since JVM is shutting down--------");
                TestServer.this.stop();
                System.err.println("-------server shut down------");
            }
        });
    }

    //    终止服务
    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }


    //    服务阻塞直到程序退出
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    //    实现服务接口的类
//    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {
//        public void testSomething(TestRequest request, StreamObserver<TestResponse> responseObserver) {
//            TestResponse build = TestResponse.newBuilder().setMessage(request.getName()).build();
////            onNext()方法向客户端返回结果
//            responseObserver.onNext(build);
//
////            告诉客户端这次调用已经完成
//            responseObserver.onCompleted();
//        }
//
//    }
    //实现服务接口的类
    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        public void testSomeThing(TestRequest request, StreamObserver<TestResponse> responseObserver) {
            TestResponse build = TestResponse.newBuilder().setMessage(request.getName()).build();
            //onNext()方法向客户端返回结果
            responseObserver.onNext(build);
            //告诉客户端这次调用已经完成
            responseObserver.onCompleted();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        final TestServer server = new TestServer();

        server.start();

        server.blockUntilShutdown();

    }

}
