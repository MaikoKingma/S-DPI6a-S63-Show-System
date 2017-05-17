package applications.ShowAPIClient;

import shared.gateway.*;
import shared.message.*;

import javax.jms.*;
import java.util.*;

/**
 * Created by Maiko on 17-5-2017.
 */
public class ShowBrokerGateway {
    private List<Request> requests;
    private MessageSenderGateway sender;
    private MessageReceiverGateway receiver;
    private String name;

    public ShowBrokerGateway(String name) {
        requests = new ArrayList<>();
        this.name = name;
        receiver = new MessageReceiverGateway(name + "RequestQueue");

        receiver.setListener(m -> {
            if (m instanceof TextMessage)
            {
                try {
                    String body = ((TextMessage)m).getText();
                    System.out.println(">>> CorrelationId: " + m.getJMSCorrelationID() + " Message: " + body);
                    OnShowAPIRequestArrived((TextMessage)m);
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void SendShowAPIReply(ShowAPIReply reply, ShowAPIRequest showAPIRequest) {
        for (Request request : requests) {
            if (request.getShowAPIRequest() == showAPIRequest)
            {
                try {
                    Message message = sender.createTextMessage(reply, request.getCorrolationId());
                    message.setIntProperty("aggregationId", request.getAggregationId());
                    sender.send(message);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public void OnShowAPIRequestArrived(TextMessage message) {
        try {
            Integer aggregationId = message.getIntProperty("aggregationId");
            if (aggregationId == null)
                return;

            ShowAPIRequest bankInterestRequest = new ShowAPIRequest();
            //bankInterestRequest.fillFromCommaSeperatedValue(message.getText());
            requests.add(new Request(message.getJMSCorrelationID(), bankInterestRequest, aggregationId));
            //ToDo
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
