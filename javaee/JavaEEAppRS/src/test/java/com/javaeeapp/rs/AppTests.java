package com.javaeeapp.rs;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import junit.framework.Assert;
import org.codehaus.jettison.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MediaType;


public class AppTests {
    public static final String URL = "http://localhost:9998/";
    private HttpServer server;

    @Before
    public void setUp() throws Exception {
        server = HttpServerFactory.create(URL);
        server.start();
    }

    @After
    public void tearDown() throws Exception {
        server.stop(0);
    }

    @Test
    public void testSayHello() throws Exception {
        Client client = Client.create();
        WebResource resource = client.resource(URL + "hello");
        JSONObject helloObject = resource.accept(MediaType.APPLICATION_JSON_TYPE).get(JSONObject.class);
        Assert.assertNotNull(helloObject);
        Assert.assertEquals("Hello world", helloObject.get("text"));
        helloObject = resource.queryParam("name", "everyone").accept(MediaType.APPLICATION_JSON_TYPE).get(JSONObject.class);
        Assert.assertEquals("Hello everyone", helloObject.get("text"));
    }
}
