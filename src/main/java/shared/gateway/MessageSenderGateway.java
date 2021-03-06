package shared.gateway;

import shared.message.MessageObject;
import com.sun.istack.Nullable;

import javax.jms.*;
import javax.naming.*;
import java.util.Properties;

/**
 * Created by Maiko on 23-4-2017.
 */
public class MessageSenderGateway {
    private final String INITIAL_CONTEXT_FACTORY = "org.apache.activemq.jndi.ActiveMQInitialContextFactory";
    private final String PROVIDER_URL = "tcp://localhost:61616";

    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageProducer producer;

    public MessageSenderGateway(String channelName) {
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        props.setProperty(Context.PROVIDER_URL, PROVIDER_URL);
        // connect to the Destination
        props.put(("queue." + channelName), channelName);

        try {
            Context jndiContext = new InitialContext(props);
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // connect to the sender destination
            destination = (Destination) jndiContext.lookup(channelName);
            producer = session.createProducer(destination);
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }

    public MessageSenderGateway(Destination destination) {
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        props.setProperty(Context.PROVIDER_URL, PROVIDER_URL);

        try {
            Context jndiContext = new InitialContext(props);
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // connect to the sender destination
            producer = session.createProducer(destination);
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public Message createTextMessage(MessageObject message, String corrolationId) {
        try {
            javax.jms.Message msg = session.createTextMessage(message.getJson());
            msg.setJMSCorrelationID(corrolationId);
            return msg;
        } catch (JMSException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void send(Message msg) {
        try {
            producer.send(msg);
            System.out.println("<<< CorrolationId: " + msg.getJMSCorrelationID() + " Message: " + ((TextMessage) msg).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
