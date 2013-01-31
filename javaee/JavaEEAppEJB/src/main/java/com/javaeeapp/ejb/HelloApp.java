package com.javaeeapp.ejb;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

public class HelloApp {
    public static void main(String[] args) throws NamingException {
        Context context = EJBContainer.createEJBContainer().getContext();
        HelloService helloService = (HelloService) context.lookup("java:global/JavaEEAppEJB/HelloService");
        System.out.println(helloService.sayHello());
    }
}
