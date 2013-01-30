package com.javaeeapp.cdi;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

public class JavaEEAppCDITests {
    @EJB
    private HelloService helloService;

    @Before
    public void setUp() throws Exception {
        EJBContainer.createEJBContainer().getContext().bind("inject", this);
    }

    @Test
    public void testSayHello() {
        Assert.assertEquals("Hello, world!", helloService.getHelloMessage());
    }
}
