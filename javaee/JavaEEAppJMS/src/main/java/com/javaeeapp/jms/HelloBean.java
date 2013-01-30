package com.javaeeapp.jms;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.jms.*;
import java.lang.IllegalStateException;

@MessageDriven
public class HelloBean implements MessageListener {
    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(name = "AnswerQueue")
    private Queue answerQueue;

    @Override
    public void onMessage(Message message) {
        try {
            final TextMessage textMessage = (TextMessage) message;
            final String hello = textMessage.getText();
            if (hello.equals("Hello!")) {
                respond("Hello back!");
            }
        } catch (JMSException e) {
            throw new IllegalStateException(e);
        }
    }

    private void respond(String text) throws JMSException {
        Connection connection = null;
        Session session = null;

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(answerQueue);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage message = session.createTextMessage(text);
            producer.send(message);
        } finally {
            if (session != null) session.close();
            if (connection != null) connection.close();
        }
    }
}
