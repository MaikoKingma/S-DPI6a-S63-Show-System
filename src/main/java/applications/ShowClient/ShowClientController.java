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
    public Label lblNoResults;
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
        clearLeftPanel();

        if (!tbSearch_isEmpty())
            return;

        System.out.println("User requested show: " + tbSearch.getText());
        manager.requestShow(tbSearch.getText());
    }

    public void btnGuess_OnAction(ActionEvent actionEvent) {
        clearLeftPanel();
        if (!tbSearch_isEmpty())
            return;

        System.out.println("User guesses show: " + tbSearch.getText());
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
        if (shows == null || shows.size() <= 0) {
            lblNoResults.setVisible(true);
        }
        else
            tvResults.setRoot(createTreeViewRoot(shows));
    }

    private void clearLeftPanel() {
        tvResults.setRoot(new TreeItem());
        lblNoResults.setVisible(false);
    }
}
