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
    private ShowClientController controller;

    public ShowClientManager(String clientname, ShowClientController controller) {
        showDAO = new ShowDAOCol();
        gateway = new ShowBrokerAppGateway(this, clientname);
        this.controller = controller;
    }

    public void showsArrived(List<Show> shows) {
        controller.showResults(shows);
    }

    public void addShow(Show show) {
        showDAO.create(show);
    }

    public void removeShow(Show show) {
        showDAO.remove(show);
    }

    public List<Show> getShows() {
        return showDAO.getAll();
    }

    public void searchShow(String request) {
        gateway.searchShow(request);
    }

    public void requestShow(String request) {
        gateway.requestShow(request);
    }
}
