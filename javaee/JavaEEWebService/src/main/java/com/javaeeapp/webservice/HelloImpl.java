package com.javaeeapp.webservice;

import javax.jws.WebService;

@WebService
public class HelloImpl {
    public String sayHello(String param) {
        return "Hello " + param;
    }
}
