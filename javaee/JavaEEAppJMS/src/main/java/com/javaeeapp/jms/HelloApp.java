package com.javaeeapp.jms;

import javax.annotation.Resource;
import javax.ejb.embeddable.EJBContainer;
import javax.jms.*;
import javax.naming.NamingException;

public class HelloApp {
    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(name = "HelloBean")
    private Queue helloQueue;

    @Resource(name = "AnswerQueue")
    private Queue answerQueue;

    public void sayHello() throws JMSException, NamingException {
        EJBContainer.createEJBContainer().getContext().bind("inject", this);

        final Connection connection = connectionFactory.createConnection();
        connection.start();

        final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        final MessageProducer questions = session.createProducer(helloQueue);
        final MessageConsumer answers = session.createConsumer(answerQueue);

        questions.send(session.createTextMessage("Hello!"));
        System.out.println(((TextMessage) answers.receive(1000)).getText());

        connection.close();
    }

    public static void main(String[] args) throws NamingException, JMSException {
        new HelloApp().sayHello();
    }
}
