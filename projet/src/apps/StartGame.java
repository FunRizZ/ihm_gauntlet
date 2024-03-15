package apps;

import apps.mainMenu.MainMenuScene;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Class to start the all game
 */
public class StartGame extends Application {

    /**
     * Start the game
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws Exception if there is an exception
     */
    @Override
    public void start (Stage primaryStage) throws Exception {

        MainScene mainController = new MainMenuScene();

        mainController.setStage(primaryStage);
        mainController.load();
        primaryStage.show();
    }


    public static void main (String args []) {
        launch (args);
    }
}
