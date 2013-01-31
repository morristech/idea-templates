package com.javaeeapp.jpa;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

public class HelloApp {
    public static void main(String[] args) throws NamingException {
        Context context = EJBContainer.createEJBContainer().getContext();
        UserService userService = (UserService) context.lookup("java:global/JavaEEAppJPA/UserService");
        User user = new User();
        user.setName("A test user");
        userService.save(user);
        System.out.println(user.getName() + "'s id is " + user.getId());
    }
}
