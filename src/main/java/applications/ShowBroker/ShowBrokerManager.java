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
        showAPIClientGateway = new ShowAPIClientAppGateway(this);
    }

    public void processRequest(ShowRequest request, String correlationId) {
        showAPIClientGateway.SendShowAPIRequest(new ShowAPIRequest(request.getRequest(), request.isGuess()), correlationId);
    }

    public void processReply(ShowReply reply, String correlationId) {
        showClientGateway.sendShowReply(reply, correlationId);
    }
}
