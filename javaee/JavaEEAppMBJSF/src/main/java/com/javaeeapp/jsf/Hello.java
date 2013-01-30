package com.javaeeapp.jsf;

import javax.faces.bean.ManagedBean;
import java.text.MessageFormat;
import java.util.ResourceBundle;

@ManagedBean
public class Hello {
    public String sayHello(String name) {
        return MessageFormat.format(ResourceBundle.getBundle("messages").getString("helloMessage"),name);
    }
}
