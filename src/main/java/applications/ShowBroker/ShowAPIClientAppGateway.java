package applications.ShowBroker;

import shared.gateway.MessageReceiverGateway;
import shared.message.ShowAPIRequest;

import javax.jms.*;

/**
 * Created by Maiko on 17-5-2017.
 */
public class ShowAPIClientAppGateway {
    private MessageReceiverGateway receiver;

    public ShowAPIClientAppGateway() {
        receiver = new MessageReceiverGateway("ShowAPIReplyQueue");

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

    private void onShowRequestArrived(String message, String correlationId) {
        //ToDo
    }

    public void SendShowAPIRequest(ShowAPIRequest request) {
        //ToDo
    }
}
