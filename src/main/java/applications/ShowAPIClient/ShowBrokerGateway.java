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
    private List<Aggregation> aggregations;
    private MessageSenderGateway sender;
    private MessageReceiverGateway receiver;
    private String name;

    public ShowBrokerGateway(String name) {
        aggregations = new ArrayList<>();
        this.name = name;
        receiver = new MessageReceiverGateway(name + "RequestQueue");

        receiver.setListener(m -> {
            if (m instanceof TextMessage)
            {
                try {
                    String body = ((TextMessage)m).getText();
                    System.out.println(">>> CorrelationId: " + m.getJMSCorrelationID() + " Message: " + body);
                    OnShowAPIRequestArrived(((TextMessage)m).getText(), m.getJMSCorrelationID(), m.getIntProperty("aggregationId"));
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void SendShowAPIReply(ShowAPIReply reply, ShowAPIRequest showAPIRequest) {
        for (Aggregation aggregation : aggregations) {
            if (aggregation.getShowAPIRequest() == showAPIRequest)
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

    public void OnShowAPIRequestArrived(String json, String correlationId, int aggregationId) {
        ShowAPIRequest showAPIRequest = new Gson().fromJson(json, ShowAPIRequest.class);
        aggregations.add(new Aggregation(correlationId, showAPIRequest, aggregationId));
        //ToDo
    }
}