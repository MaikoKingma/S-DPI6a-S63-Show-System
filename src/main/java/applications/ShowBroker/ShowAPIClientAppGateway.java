package applications.ShowBroker;

import com.google.gson.Gson;
import com.sun.istack.NotNull;
import shared.gateway.MessageReceiverGateway;
import shared.gateway.MessageSenderGateway;
import shared.message.*;

import javax.jms.*;
import java.util.*;

/**
 * Created by Maiko on 17-5-2017.
 */
public class ShowAPIClientAppGateway {
    private ShowBrokerManager manager;
    private MessageReceiverGateway receiver;
    private List<Aggregation> aggregations;
    @NotNull
    private int id = 0;
    private List<Rule> bankRules = new ArrayList<Rule>() {{
        add(new Rule("Faker", false));
    }};

    public ShowAPIClientAppGateway(ShowBrokerManager manager) {
        aggregations = new ArrayList<>();
        this.manager = manager;
        receiver = new MessageReceiverGateway("ShowAPIReplyQueue");for (Rule rule : bankRules) {
            rule.setSender(new MessageSenderGateway(rule.getApiName() + "RequestQueue"));
        }

        receiver.setListener(m -> {
            if (m instanceof TextMessage)
            {
                try {
                    String body = ((TextMessage)m).getText();
                    System.out.println(">>> CorrelationId: " + m.getJMSCorrelationID() + " Message: " + body);
                    onShowAPIReplyArrived(((TextMessage)m).getText(), m.getJMSCorrelationID(), m.getIntProperty("aggregationId"));
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void onShowAPIReplyArrived(String json, String correlationId, int aggregationId) {
        ShowAPIReply reply = new Gson().fromJson(json, ShowAPIReply.class);
        Aggregation foundAggregation = null;
        for (Aggregation aggregation : aggregations) {
            if (aggregation.getId() == aggregationId) {
                foundAggregation = aggregation;
                break;
            }
        }
        if (foundAggregation != null) {
            foundAggregation.addShowAPIReply(reply);
            if (foundAggregation.repliesReceived()){
                manager.processReply(foundAggregation.getBestReply(), correlationId);
            }
        }
    }

    public void SendShowAPIRequest(ShowAPIRequest request, String correlationId) {
        int aggregationId = getAggregationID();
        int expectedReplies = 0;
        List<Rule> rulesToSend = new ArrayList<>();
        for (Rule rule : bankRules) {
            if ((request.isGuess() && rule.hasSearch()) || !request.isGuess()) {
                expectedReplies++;
                rulesToSend.add(rule);
            }
        }
        aggregations.add(new Aggregation(aggregationId, expectedReplies, correlationId));
        for (Rule rule : rulesToSend) {
            try {
                MessageSenderGateway sender = rule.getSender();
                Message message = sender.createTextMessage(request, correlationId);
                message.setIntProperty("aggregationId", aggregationId);
                sender.send(message);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    @NotNull
    private int getAggregationID()
    {
        id++;
        return id;
    }
}
