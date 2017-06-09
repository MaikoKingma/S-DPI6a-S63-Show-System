package applications.ShowClient;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import shared.show.Episode;
import shared.show.IShow;
import shared.show.Show;

import java.util.List;

/**
 * Created by Maiko on 23-4-2017.
 */
public class ShowClientController {

    //Left Pane
    public Button btnFind;
    public TextField tbSearch;
    public Button btnGuess;
    public TreeView tvResults;
    public Button btnAdd;
    //Right Pane
    public TreeView tvShows;
    public Button btnRemove;

    private ShowClientManager manager;

    public void setName(String name) {
        tvShows.setShowRoot(false);
        tvResults.setShowRoot(false);

        manager = new ShowClientManager(name, this);
        tvShows.setRoot(createTreeViewRoot(manager.getShows()));
    }

    public void btnFind_OnAction(ActionEvent actionEvent) {
        if (tbSearch_isEmpty())
            return;

        manager.requestShow(tbSearch.getText());
    }

    public void btnGuess_OnAction(ActionEvent actionEvent) {
        if (tbSearch_isEmpty())
            return;

        manager.searchShow(tbSearch.getText());
    }

    private boolean tbSearch_isEmpty() {
        if (tbSearch.getText() == null || tbSearch.getText().isEmpty())
            return false;
        return true;
    }

    public void btnAdd_OnAction(ActionEvent actionEvent) {
        //ToDo
    }

    public void btnRemove_OnAction(ActionEvent actionEvent) {
        //ToDo
    }

    private TreeItem<IShow> createTreeViewRoot(List<Show> shows) {
        TreeItem<IShow> rootItem = new TreeItem<>();
        rootItem.setExpanded(true);
        for (Show s : shows) {
            TreeItem<IShow> newItem = new TreeItem<> (s);
            for (Episode e : s.getEpisodes()) {
                newItem.getChildren().add(new TreeItem<>(e));
            }
            rootItem.getChildren().add(newItem);
        }
        return rootItem;
    }

    void showResults(List<Show> shows) {
        tvResults.setRoot(createTreeViewRoot(shows));
    }
}
