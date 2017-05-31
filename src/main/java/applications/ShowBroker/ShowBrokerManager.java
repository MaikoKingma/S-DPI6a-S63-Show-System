package applications.ShowBroker;

import shared.message.*;

/**
 * Created by Maiko on 31-5-2017.
 */
public class ShowBrokerManager {
    private ShowClientAppGateway showClientGateway;
    private ShowAPIClientAppGateway showAPIClientGateway;

    public ShowBrokerManager() {
        showClientGateway = new ShowClientAppGateway(this);
        showAPIClientGateway = new ShowAPIClientAppGateway();
    }

    public void processRequest(ShowRequest request, String correlationId) {
        showAPIClientGateway.SendShowAPIRequest(new ShowAPIRequest(request.getRequest(), request.isGuess()), correlationId);
        //ToDo Check
    }

    public void processReply(ShowAPIReply reply, String correlationId) {
        showClientGateway.sendShowReply(new ShowReply(reply.getShows()), correlationId);
        //ToDo
    }
}
