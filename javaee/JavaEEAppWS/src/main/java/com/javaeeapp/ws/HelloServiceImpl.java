package com.javaeeapp.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.javaeeapp.ws.HelloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String param) {
        return "Hello " + param;
    }
}
