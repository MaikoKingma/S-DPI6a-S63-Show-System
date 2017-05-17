package applications.ShowAPIClient;

import shared.gateway.*;
import shared.message.ShowAPIReply;

import javax.jms.*;

/**
 * Created by Maiko on 17-5-2017.
 */
public class ShowBrokerGateway {
    private MessageSenderGateway sender;
    private MessageReceiverGateway receiver;
    private String name;

    public ShowBrokerGateway(String name) {
        this.name = name;
        receiver = new MessageReceiverGateway(name + "RequestQueue");

        receiver.setListener(m -> {
            if (m instanceof TextMessage)
            {
                try {
                    String body = ((TextMessage)m).getText();
                    System.out.println(">>> CorrelationId: " + m.getJMSCorrelationID() + " Message: " + body);
                    OnShowAPIRequestArrived(((TextMessage)m).getText(), m.getJMSCorrelationID());
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void SendShowAPIReply(ShowAPIReply reply) {
        //ToDo
    }

    public void OnShowAPIRequestArrived(String message, String correlationId) {
        //ToDo
    }
}
