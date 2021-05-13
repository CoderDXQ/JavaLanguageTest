package com.example.grpchelloworld;

import com.example.justtest.Greeter1Grpc;
import com.example.justtest.HelloWorld;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/13 11:28 下午
 */
public class HelloWorldClients {

    /**
     * gRPC客户端支持三种调用方式：
     * 1.同步调用
     * 2.基于回调的异步调用
     * 3.基于Future的异步调用
     */
    public static final Logger logger = Logger.getLogger(HelloWorldClients.class.getName());

    private String host;
    private int port;

    public HelloWorldClients(String host, int port) {
        this.host = host;
        this.port = port;
    }

    //    获取通道
    public ManagedChannel getChannel() {
        return ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    }

    //    同步调用 阻塞
    public void doSync(String name) {
//        阻塞桩
        Greeter1Grpc.Greeter1BlockingStub blockingStub = Greeter1Grpc.newBlockingStub(getChannel());

        logger.info("Will try to doSync");

        HelloWorld.HelloRequest request = HelloWorld.HelloRequest.newBuilder().setName(name).build();

        HelloWorld.HelloReply response;

        try {
//            桩执行rpc调用
            response = blockingStub.sayHello(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return;
        }

        logger.info("Greeting: " + response.getMessage());

    }

    //    基于回调的异步调用
    public void doAsync(String name) {
        //        桩
        Greeter1Grpc.Greeter1Stub stub = Greeter1Grpc.newStub(getChannel());

        logger.info("Will try to doAsync");

        HelloWorld.HelloRequest request = HelloWorld.HelloRequest.newBuilder().setName(name).build();

//        桩执行rpc调用
        stub.sayHello(request, new StreamObserver<HelloWorld.HelloReply>() {
            @Override
            public void onNext(HelloWorld.HelloReply value) {
                logger.info("Greeting: " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                logger.log(Level.WARNING, "RPC failed: {0}", t);
            }

            @Override
            public void onCompleted() {
            }
        });

    }


    //    基于Future的异步调用
    public void doFuture(String name) {

//        Future桩
        Greeter1Grpc.Greeter1FutureStub futureStub = Greeter1Grpc.newFutureStub(getChannel());

        logger.info("Will try to doFuture");
        HelloWorld.HelloRequest request = HelloWorld.HelloRequest.newBuilder().setName(name).build();
        HelloWorld.HelloReply response;


        try {
//            桩执行rpc调用
            ListenableFuture<HelloWorld.HelloReply> future = futureStub.sayHello(request);
            response = future.get();
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "RPC failed: {0}", e);
            return;
        } catch (ExecutionException e) {
            logger.log(Level.SEVERE, "RPC failed: {0}", e);
            return;
        }
        logger.info("Greeting: " + response.getMessage());
    }


    public static void main(String[] args) {
        HelloWorldClients client = new HelloWorldClients("localhost", 50052);


        String user;

//    三种调用方式
        user = "world0";
        client.doSync(user);

        user = "world1";
        client.doAsync(user);

        user = "world2";
        client.doFuture(user);
    }

}
