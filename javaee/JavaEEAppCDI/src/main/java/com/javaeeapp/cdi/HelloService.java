package com.javaeeapp.cdi;

import javax.ejb.Stateless;

@Stateless
public class HelloService {
    public String getHelloMessage() {
        return "Hello, world!";
    }
}
