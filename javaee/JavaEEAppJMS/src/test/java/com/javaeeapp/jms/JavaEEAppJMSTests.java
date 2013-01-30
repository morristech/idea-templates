package com.javaeeapp.jms;

import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import javax.ejb.embeddable.EJBContainer;
import javax.jms.*;
import javax.naming.NamingException;

public class JavaEEAppJMSTests {
    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(name = "HelloBean")
    private Queue helloQueue;

    @Resource(name = "AnswerQueue")
    private Queue answerQueue;

    @Test
    public void testHello() throws JMSException, NamingException {
        EJBContainer.createEJBContainer().getContext().bind("inject", this);

        final Connection connection = connectionFactory.createConnection();
        connection.start();

        final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        final MessageProducer questions = session.createProducer(helloQueue);
        final MessageConsumer answers = session.createConsumer(answerQueue);

        questions.send(session.createTextMessage("Hello!"));
        Assert.assertEquals("Hello back!", ((TextMessage) answers.receive(1000)).getText());

        connection.close();
    }
}
