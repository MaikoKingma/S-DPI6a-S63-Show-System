package applications.ShowAPIClient;

import applications.ShowAPIClient.APIs.FakerAPIReader;
import applications.ShowAPIClient.APIs.IAPIReader;
import shared.message.ShowAPIReply;
import shared.message.ShowAPIRequest;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Maiko on 31-5-2017.
 */
public class ShowAPIClientManager {
    private ShowBrokerGateway gateway;
    private IAPIReader currentReader;

    public ShowAPIClientManager(String name, readers reader) {
        gateway = new ShowBrokerGateway(name, this);
        switch (reader) {
            case faker:
                currentReader = new FakerAPIReader();
                break;
            case TVMaze:
            case TheTVDB:
            case EpisoDate:
                //ToDo
                throw new NotImplementedException();
        }
    }

    public ShowAPIReply processRequest(ShowAPIRequest request) {
        if (request.isGuess())
            return new ShowAPIReply(currentReader.searchShow(request.getRequest()));
        return new ShowAPIReply(currentReader.getShow(request.getRequest()));
    }
}

enum readers {
    faker,
    TheTVDB,
    EpisoDate,
    TVMaze
}
