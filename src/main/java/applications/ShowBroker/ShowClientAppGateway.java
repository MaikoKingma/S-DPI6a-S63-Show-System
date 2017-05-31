package applications.ShowBroker;

import com.google.gson.Gson;
import shared.gateway.*;
import shared.message.ShowReply;
import shared.message.ShowRequest;

import javax.jms.*;
import java.util.*;

/**
 * Created by Maiko on 12-5-2017.
 */
public class ShowClientAppGateway {
    private ShowBrokerManager manager;
    private MessageReceiverGateway receiver;
    private List<Request> showRequests;

    public ShowClientAppGateway(ShowBrokerManager manager) {
        this.manager = manager;
        showRequests = new ArrayList<>();
        receiver = new MessageReceiverGateway("showClientRequestQueue");

        receiver.setListener(m -> {
            if (m instanceof TextMessage)
            {
                try {
                    String body = ((TextMessage)m).getText();
                    System.out.println(">>> CorrelationId: " + m.getJMSCorrelationID() + " Message: " + body);
                    onShowRequestArrived(((TextMessage)m).getText(), m.getJMSCorrelationID(), m.getJMSReplyTo());
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onShowRequestArrived(String json, String correlationId, Destination replyTo) {
        ShowRequest request = new Gson().fromJson(json, ShowRequest.class);
        showRequests.add(new Request(correlationId, request, replyTo));
        manager.processRequest(request, correlationId);
    }

    public void sendShowReply(ShowReply reply, String correlationId) {
        for (Request request : showRequests) {
            if (request.getCorrolationId().equals(correlationId)) {
                MessageSenderGateway sender = new MessageSenderGateway(request.getReplyTo());
                Message message = sender.createTextMessage(reply, correlationId);
                sender.send(message);
                break;
            }
        }
    }
}
