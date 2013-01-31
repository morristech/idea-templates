package com.javaeeapp.rs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HelloMessage sayHello(@QueryParam("name") @DefaultValue("world") String name) {
        return new HelloMessage("Hello " + name);
    }
}
