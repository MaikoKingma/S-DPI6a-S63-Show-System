package applications.ShowBroker;

import shared.gateway.*;
import shared.message.ShowReply;

import javax.jms.*;

/**
 * Created by Maiko on 12-5-2017.
 */
public class ShowClientAppGateway {
    private MessageReceiverGateway receiver;

    public ShowClientAppGateway() {
        receiver = new MessageReceiverGateway("showClientRequestQueue");

        receiver.setListener(m -> {
            if (m instanceof TextMessage)
            {
                try {
                    String body = ((TextMessage)m).getText();
                    System.out.println(">>> CorrelationId: " + m.getJMSCorrelationID() + " Message: " + body);
                    onShowRequestArrived(((TextMessage)m).getText(), m.getJMSCorrelationID());
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onShowRequestArrived(String message, String correlationId) {

    }

    public void sendShowReply(ShowReply reply) {
        MessageSenderGateway sender = new MessageSenderGateway()
    }
}
