package com.javaeeapp.ws;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.URL;

public class HelloTests {
    private Endpoint endpoint;

    @Before
    public void setUp() {
        endpoint = Endpoint.publish("http://127.0.0.1:4204/hello", new HelloImpl());
    }

    @After
    public void tearDown() {
        endpoint.stop();
    }

    @Test
    public void testSayHello() throws Exception {
        Service service = Service.create(new URL("http://127.0.0.1:4204/hello?wsdl"),
                new QName("http://ws.javaeeapp.com/", "HelloImplService"));
        Assert.assertNotNull(service);
        Hello hello = service.getPort(Hello.class);
        Assert.assertNotNull(hello);
        Assert.assertEquals("Hello test", hello.sayHello("test"));
    }
}
