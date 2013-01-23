package com.springapp;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    public String getHelloMessage() {
        return "Hello, world!";
    }
}
