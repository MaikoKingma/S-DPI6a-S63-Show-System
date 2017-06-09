package applications.ShowAPIClient;

import com.google.gson.Gson;
import shared.gateway.*;
import shared.message.*;

import javax.jms.*;
import java.util.*;

/**
 * Created by Maiko on 17-5-2017.
 */
public class ShowBrokerGateway {
    private ShowAPIClientManager manager;
    private List<Aggregation> aggregations;
    private MessageSenderGateway sender;
    private MessageReceiverGateway receiver;
    private String name;

    public ShowBrokerGateway(String name, ShowAPIClientManager manager) {
        this.manager = manager;
        aggregations = new ArrayList<>();
        this.name = name;
        sender = new MessageSenderGateway("ShowAPIReplyQueue");
        receiver = new MessageReceiverGateway(name + "RequestQueue");
        receiver.setListener(m -> {
            if (m instanceof TextMessage)
            {
                try {
                    String body = ((TextMessage)m).getText();
                    System.out.println(">>> CorrelationId: " + m.getJMSCorrelationID() + " Message: " + body);
                    onShowAPIRequestArrived(((TextMessage)m).getText(), m.getJMSCorrelationID(), m.getIntProperty("aggregationId"));
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void sendShowAPIReply(ShowAPIReply reply, String correlationId) {
        for (Aggregation aggregation : aggregations) {
            if (aggregation.getCorrolationId().equals(correlationId))
            {
                try {
                    Message message = sender.createTextMessage(reply, aggregation.getCorrolationId());
                    message.setIntProperty("aggregationId", aggregation.getAggregationId());
                    sender.send(message);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public void onShowAPIRequestArrived(String json, String correlationId, int aggregationId) {
        ShowAPIRequest showAPIRequest = new Gson().fromJson(json, ShowAPIRequest.class);
        aggregations.add(new Aggregation(correlationId, showAPIRequest, aggregationId));
        sendShowAPIReply(manager.processRequest(showAPIRequest), correlationId);
    }
}