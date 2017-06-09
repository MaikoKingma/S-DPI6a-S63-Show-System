package applications.ShowClient;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

/**
 * Created by Maiko on 23-4-2017.
 */
public class ShowClientController {

    //Left
    public Button btnFind;
    public TextField tbSearch;
    public Button btnGuess;
    public TreeView tvResults;
    public Button btnAdd;
    //Right
    public TreeView tvShows;
    public Button btnRemove;

    private ShowClientManager manager;

    public void setName(String name) {
        manager = new ShowClientManager(name);
    }

    public void btnFind_OnAction(ActionEvent actionEvent) {
        //ToDo
    }

    public void btnRemove_OnAction(ActionEvent actionEvent) {
        //ToDo
    }

    public void btnAdd_OnAction(ActionEvent actionEvent) {
        //ToDo
    }

    public void btnGuess_OnAction(ActionEvent actionEvent) {
        //ToDo
    }
}
