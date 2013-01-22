package com.springapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.springapp");
        HelloService service = context.getBean(HelloService.class);
        service.sayHello();
    }
}
