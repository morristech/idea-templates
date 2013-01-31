package com.springapp.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class HelloApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = new User();
        user.setName("A test user");
        userRepository.save(user);
        System.out.println(user.getName() + "'s id is " + user.getId());
    }
}
