package applications.ShowClient;

/**
 * Created by Maiko on 23-4-2017.
 */
public class ShowClientController {

    private ShowClientManager manager;

    public void setName(String name) {
        manager = new ShowClientManager(name);
    }
}
