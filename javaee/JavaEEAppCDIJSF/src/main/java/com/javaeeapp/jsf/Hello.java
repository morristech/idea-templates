package com.javaeeapp.jsf;

import javax.inject.Named;
import java.text.MessageFormat;
import java.util.ResourceBundle;

@Named
public class Hello {
    public String sayHello(String name) {
        return MessageFormat.format(ResourceBundle.getBundle("messages").getString("helloMessage"),name);
    }
}
