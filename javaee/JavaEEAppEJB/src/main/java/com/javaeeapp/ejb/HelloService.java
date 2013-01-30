package com.javaeeapp.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloService {
    public String getHelloMessage() {
        return "Hello, world!";
    }
}
