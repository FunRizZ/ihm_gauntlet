package apps;

import apps.mapcreator.MapCreatorScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StartGame extends Application {
    @Override
    public void start (Stage primaryStage) throws Exception {

        MainScene mainController = new MapCreatorScene();

        mainController.setStage(primaryStage);
        mainController.load();
        Scene scene = mainController.getScene();
        primaryStage.show();
    }


    public static void main (String args []) {
        launch (args);
    }
}
