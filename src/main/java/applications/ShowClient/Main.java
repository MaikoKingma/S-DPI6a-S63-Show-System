package applications.ShowClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Maiko on 23-4-2017.
 */

public class Main extends Application {
    private static String name;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ShowClient.fxml"));
        Parent root = fxmlLoader.load();
        ShowClientController controller = fxmlLoader.getController();
        controller.setName(name);
        primaryStage.setTitle("ShowClient");
        primaryStage.setScene(new Scene(root, 900, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        if(args[0] != null && !args[0].isEmpty()) {
            name = args[0];
            launch(args);
        }
    }
}
