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
        endpoint = Endpoint.publish("http://127.0.0.1:4204/hello", new HelloServiceImpl());
    }

    @After
    public void tearDown() {
        endpoint.stop();
    }

    @Test
    public void testSayHello() throws Exception {
        Service service = Service.create(new URL("http://127.0.0.1:4204/hello?wsdl"),
                new QName("http://ws.javaeeapp.com/", "HelloServiceImplService"));
        Assert.assertNotNull(service);
        HelloService helloService = service.getPort(HelloService.class);
        Assert.assertNotNull(helloService);
        Assert.assertEquals("Hello test", helloService.sayHello("test"));
    }
}
