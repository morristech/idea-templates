package com.javaeeapp.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;
import java.util.ResourceBundle;

@RequestScoped
@Named
public class HelloBean {
    @Inject
    private Hello hello;

    @Size(min = 1, max = 45)
    private String name;

    private String result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String sayHello() {
        result = hello.sayHello(name);
        return "success";
    }
}
