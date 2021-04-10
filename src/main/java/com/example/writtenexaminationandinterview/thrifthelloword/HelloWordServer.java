package com.example.writtenexaminationandinterview.thrifthelloword;

import gen.HelloWordService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;


/**w
 *
 * REFERENCE: https://blog.csdn.net/u013725455/article/details/62427004
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/10 11:55 上午
 */
public class HelloWordServer {

    public static void main(String[] args) throws Exception {

        TServerSocket serverSocket = new TServerSocket(8888);

        HelloWordService.Processor processor = new HelloWordService.Processor(new HelloWordServiceImpl());

        TServer.Args serverParams = new TServer.Args(serverSocket);
        serverParams.protocolFactory(new TBinaryProtocol.Factory());
        serverParams.processor(processor);

        TServer server = new TSimpleServer(serverParams);


        System.out.println("Running server......");

        server.serve();

    }

}
