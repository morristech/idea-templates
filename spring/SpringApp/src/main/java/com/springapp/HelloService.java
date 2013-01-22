package com.springapp;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    public void sayHello() {
        System.out.println("Hello, world!");
    }
}
