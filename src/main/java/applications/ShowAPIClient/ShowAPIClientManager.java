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

    public ShowAPIClientManager(readers reader) {
        switch (reader) {
            case Faker:
                currentReader = new FakerAPIReader();
                break;
            case TVMaze:
            case TheTVDB:
            case EpisoDate:
                //ToDo
                throw new NotImplementedException();
        }
        gateway = new ShowBrokerGateway(reader.toString(), this);
    }

    public ShowAPIReply processRequest(ShowAPIRequest request) {
        if (request.isGuess())
            return new ShowAPIReply(currentReader.searchShow(request.getRequest()));
        return new ShowAPIReply(currentReader.getShow(request.getRequest()));
    }
}

/**
 * List of readers this client can implement
 */
enum readers {
    Faker,
    TheTVDB,
    EpisoDate,
    TVMaze
}
