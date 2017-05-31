package applications.ShowBroker;

import shared.gateway.MessageSenderGateway;

/**
 * Created by Maiko on 31-5-2017.
 */
public class Rule {
    private String apiName;
    private boolean hasSearch;

    private MessageSenderGateway sender;

    public Rule(String apiName, boolean hasSearch) {
        this.apiName = apiName;
        this.hasSearch = hasSearch;
    }

    public String getApiName() {
        return apiName;
    }

    public boolean hasSearch() {
        return hasSearch;
    }

    public MessageSenderGateway getSender() {
        return sender;
    }

    public void setSender(MessageSenderGateway sender) {
        this.sender = sender;
    }
}
