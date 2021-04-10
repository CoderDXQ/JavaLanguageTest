package com.example.writtenexaminationandinterview.thrifthelloword;

import gen.HelloWordService;
import gen.Request;
import gen.RequestException;
import gen.RequestType;
import org.apache.thrift.TException;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/10 11:38 上午
 */

//服务的实现类
public class HelloWordServiceImpl implements HelloWordService.Iface {


    //    这个方法在Test.thrift中有定义
    @Override
    public String doAction(Request request) throws RequestException, TException {
        System.out.println("Get request: " + request);
        if (StringUtils.isBlank(request.getName()) || request.getType() == null) {
            throw new RequestException();
        }
        String result = "Hello, " + request.getName();
        if (request.getType() == RequestType.SAY_HELLO) {
            result += ",welcome!";
        } else {
            result += ", Now is " + new Date().toLocaleString();
        }
        return result;
    }

}
