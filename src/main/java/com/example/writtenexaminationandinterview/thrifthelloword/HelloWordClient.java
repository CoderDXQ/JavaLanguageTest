package com.example.writtenexaminationandinterview.thrifthelloword;

import gen.HelloWordService;
import gen.Request;
import gen.RequestType;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/10 12:26 下午
 */
public class HelloWordClient {

    public static void main(String[] args) throws TException {

        TTransport transport = new TSocket("localhost", 8888);
        TProtocol protocol = new TBinaryProtocol(transport);

//         创建client
        HelloWordService.Client client = new HelloWordService.Client(protocol);
        transport.open();

//        第一种请求类型
        Request request = new Request().setType(RequestType.SAY_HELLO).setName("dada").setAge(24);
        System.out.println(client.doAction(request));

//        第二种请求类型
        request.setType(RequestType.QUERY_TIME).setName("xiaoxiao");
        System.out.println(client.doAction(request));

        transport.close();


    }

}
