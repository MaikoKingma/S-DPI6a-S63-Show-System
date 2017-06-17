package applications.ShowClient;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import shared.show.*;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Maiko on 23-4-2017.
 */
public class ShowClientController {

    private String currYouTubeLink;

    //Left Pane
    public Button btnFind;
    public TextField tbSearch;
    public Button btnGuess;
    public Label lblNoResults;
    public TreeView tvResults;
    public Button btnAdd;
    //Middle Pane
    public TreeView tvShows;
    public Button btnRemove;
    //Right Pane
    public TextArea taInfo;
    public Button btnYouTube;

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

    public void tvShows_OnMouseClicked(MouseEvent mouseEvent) {
        Object selectedItem = tvShows.getSelectionModel().getSelectedItem();
        if (selectedItem != null && ((TreeItem)selectedItem).getValue() instanceof Show) {
            fillRightPane((Show)((TreeItem)selectedItem).getValue());
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

    public void tvResults_OnMouseClicked(MouseEvent mouseEvent) {
        Object selectedItem = tvResults.getSelectionModel().getSelectedItem();
        if (selectedItem != null && ((TreeItem)selectedItem).getValue() instanceof Show) {
            fillRightPane((Show)((TreeItem)selectedItem).getValue());
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

    private void fillRightPane(Show show) {
        StringBuilder builder = new StringBuilder();
        builder.append("SourceId: ");
        builder.append(show.getSourceId() + "\n");
        builder.append("Name: ");
        builder.append(show.getName() + "\n\n");
        builder.append(show.getDescription() + "\n\n");
        builder.append("Genres: ");
        if (show.getGenres() != null) {
            for (String genre : show.getGenres()) {
                builder.append(genre + " ");
            }
        }
        builder.append("\n");
        builder.append("Network: ");
        builder.append(show.getNetwork() + "\n");
        builder.append("Rating: ");
        builder.append(show.getRating() + "\\10 from " + show.getRatingCount() + " users\n");
        builder.append("Status: ");
        builder.append(show.getStatus().toString() + "\n");
        builder.append("Start date: ");
        if (show.getStartDate() != null) {
            builder.append(new SimpleDateFormat("dd-MM-yyyy").format(show.getStartDate().getTime()));
        }
        builder.append("\n");
        builder.append("Episodes: ");
        if (show.getEpisodes() != null) {
            builder.append(show.getEpisodes().size());
        }
        builder.append("\n");
        builder.append("Next episode: ");
        if (show.getCountdown() != null) {
            builder.append(show.getCountdown().toString());
        }
        taInfo.setText(builder.toString());

        if (show.getYoutubeLink() != null && !show.getYoutubeLink().isEmpty()) {
            currYouTubeLink = show.getYoutubeLink();
            btnYouTube.setVisible(true);
        }
        else {
            btnYouTube.setVisible(false);
        }
    }


    public void btnYouTube_OnAction(ActionEvent actionEvent) {
        if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=" + currYouTubeLink));
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
