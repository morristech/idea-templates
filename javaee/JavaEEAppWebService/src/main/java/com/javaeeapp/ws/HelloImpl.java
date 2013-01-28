package com.javaeeapp.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.javaeeapp.ws.Hello")
public class HelloImpl implements Hello {
    @Override
    public String sayHello(String param) {
        return "Hello " + param;
    }
}
