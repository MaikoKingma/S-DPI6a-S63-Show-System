package applications.ShowClient;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import shared.show.*;

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
        return !(tbSearch.getText() == null || tbSearch.getText().isEmpty());
    }

    public void btnAdd_OnAction(ActionEvent actionEvent) {
        Object selectedItem = tvResults.getSelectionModel().getSelectedItem();
        //If The user Selected nothing or a episode nothing happens.
        if (selectedItem != null && ((TreeItem)selectedItem).getValue() instanceof Show) {
            manager.addShow((Show)((TreeItem)selectedItem).getValue());
            tvShows.setRoot(createTreeViewRoot(manager.getShows()));
        }
    }

    public void btnRemove_OnAction(ActionEvent actionEvent) {
        Object selectedItem = tvShows.getSelectionModel().getSelectedItem();
        //If The user Selected nothing or a episode nothing happens.
        if (selectedItem != null && ((TreeItem)selectedItem).getValue() instanceof Show) {
            manager.removeShow((Show)((TreeItem)selectedItem).getValue());
            tvShows.setRoot(createTreeViewRoot(manager.getShows()));
        }
    }

    /**
     * Creates a TreeItem than can be used as a rootItem for displaying a show list.
     */
    private TreeItem<IShow> createTreeViewRoot(List<Show> shows) {
        TreeItem<IShow> rootItem = new TreeItem<>();
        rootItem.setExpanded(true);

        for (Show s : shows) {
            TreeItem<IShow> newItem = new TreeItem<> (s);
            if (s.getEpisodes() != null) {
                for (Episode e : s.getEpisodes()) {
                    newItem.getChildren().add(new TreeItem<>(e));
                }
            }
            rootItem.getChildren().add(newItem);
        }
        return rootItem;
    }

    void showResults(List<Show> shows) {
        if (shows == null || shows.size() <= 0) {
            Platform.runLater(() -> lblNoResults.setVisible(true));
        }
        else
            Platform.runLater(() -> tvResults.setRoot(createTreeViewRoot(shows)));
    }

    private void clearLeftPanel() {
        tvResults.setRoot(new TreeItem());
        lblNoResults.setVisible(false);
    }
}
