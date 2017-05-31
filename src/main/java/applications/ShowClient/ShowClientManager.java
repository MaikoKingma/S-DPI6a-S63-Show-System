package applications.ShowClient;

import shared.show.Show;

import java.util.List;

/**
 * Created by Maiko on 31-5-2017.
 */
public class ShowClientManager {

    private ShowBrokerAppGateway gateway;
    //ToDo Add DAOCol

    public ShowClientManager(String clientname) {
        gateway = new ShowBrokerAppGateway(this, clientname);
    }

    public void showsArrived(List<Show> shows) {
        saveShows(shows);
        //ToDo Send to UI
    }

    private void saveShows(List<Show> shows) {
        //ToDo
    }

    public void searchShow(String request) {
        gateway.searchShow(request);
    }

    public void requestShow(String request) {
        gateway.requestShow(request);
    }
}
