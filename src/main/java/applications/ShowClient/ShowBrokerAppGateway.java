package applications.ShowClient;

import com.google.gson.Gson;
import com.sun.istack.NotNull;
import shared.gateway.*;
import shared.message.*;

import javax.jms.*;
import java.util.*;

/**
 * Created by Maiko on 23-4-2017.
 */
public class ShowBrokerAppGateway {
    private MessageSenderGateway sender;
    private MessageReceiverGateway receiver;
    private Map<String, ShowRequest> showRequests;
    @NotNull
    private String name = "clientName";
    @NotNull
    private int Id = 0;

    public ShowBrokerAppGateway() {
        showRequests = new HashMap<>();
        sender = new MessageSenderGateway("showClientRequestQueue");
        receiver = new MessageReceiverGateway(name + "ReplyQueue");

        receiver.setListener(m -> {
            if (m instanceof TextMessage)
            {
                try {
                    String body = ((TextMessage)m).getText();
                    System.out.println(">>> CorrelationId: " + m.getJMSCorrelationID() + " Message: " + body);
                    onShowReplyArrived(((TextMessage)m).getText(), m.getJMSCorrelationID());
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void searchShow(String request) {
        sendRequest(new ShowRequest(request, true));
    }

    public void requestShow(String request) {
        sendRequest(new ShowRequest(request));
    }

    private void sendRequest(ShowRequest request) {
        try {
            String correlationId = getCorrolationId();
            showRequests.put(correlationId, request);
            Message message = sender.createTextMessage(request, correlationId);
            message.setJMSReplyTo(receiver.getDestination());
            sender.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void onShowReplyArrived(String json, String correlationId) {
        ShowReply reply = new Gson().fromJson(json, ShowReply.class);
        ShowRequest request = showRequests.get(correlationId);
        //ToDo
    }

    @NotNull
    private String getCorrolationId()
    {
        Id++;
        return name + Integer.toString(Id);
    }
}