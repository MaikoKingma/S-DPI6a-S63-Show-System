package applications.ShowAPIClient;

import shared.message.ShowAPIReply;
import shared.message.ShowAPIRequest;

/**
 * Created by Maiko on 31-5-2017.
 */
public class ShowAPIClientManager {
    private ShowBrokerGateway gateway;

    public ShowAPIClientManager(String name) {
        gateway = new ShowBrokerGateway(name, this);
    }

    public ShowAPIReply processRequest(ShowAPIRequest request) {
        //ToDo
        return new ShowAPIReply();
    }
}
