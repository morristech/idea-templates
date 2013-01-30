package com.javaeeapp.jsf;

import javax.ejb.Stateless;
import java.text.MessageFormat;
import java.util.ResourceBundle;

@Stateless
public class Hello {
    public String sayHello(String name) {
        return MessageFormat.format(ResourceBundle.getBundle("messages").getString("helloMessage"),name);
    }
}
