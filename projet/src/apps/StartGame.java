package apps;

import apps.game.pause.PauseScene;
import apps.mainMenu.MainMenuScene;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

        MainScene.scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                PauseScene pauseScene = new PauseScene();
                pauseScene.loadNewScene();
            }
        });

        primaryStage.show();
    }


    public static void main (String args []) {
        launch (args);
    }
}
