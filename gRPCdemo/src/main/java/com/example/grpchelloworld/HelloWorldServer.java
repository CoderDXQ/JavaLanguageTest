package com.example.grpchelloworld;


import com.example.justtest.Greeter1Grpc;
import com.example.justtest.HelloWorld;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/13 11:57 下午
 */
public class HelloWorldServer {

    public static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());

    private Server server;

    private void start() throws IOException {

        int port = 50052;
        server = ServerBuilder.forPort(port).addService(new Greeter1Impl()).build().start();

        logger.info("Server started,listening on " + port);

//        JVM退出时服务也退出
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    HelloWorldServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }

        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        final HelloWorldServer server = new HelloWorldServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class Greeter1Impl extends Greeter1Grpc.Greeter1ImplBase {
        @Override
        public void sayHello(HelloWorld.HelloRequest request, StreamObserver<HelloWorld.HelloReply> responseObserver) {
//            组装reply
            HelloWorld.HelloReply reply = HelloWorld.HelloReply.newBuilder().setMessage("Hello" + request.getName()).build();
//            发送
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }


}
