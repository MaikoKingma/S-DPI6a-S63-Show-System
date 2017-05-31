package applications.ShowClient;

import applications.ShowClient.DAO.ShowDAOCol;
import shared.show.Show;

import java.util.List;

/**
 * Created by Maiko on 31-5-2017.
 */
public class ShowClientManager {

    private ShowBrokerAppGateway gateway;
    private ShowDAOCol showDAO;

    public ShowClientManager(String clientname) {
        showDAO = new ShowDAOCol();
        gateway = new ShowBrokerAppGateway(this, clientname);
    }

    public void showsArrived(List<Show> shows) {
        saveShows(shows);
        //ToDo Send to UI
    }

    private void saveShows(List<Show> shows) {
        for (Show s : shows) {
            showDAO.create(s);
        }
    }

    public void searchShow(String request) {
        gateway.searchShow(request);
    }

    public void requestShow(String request) {
        gateway.requestShow(request);
    }
}
