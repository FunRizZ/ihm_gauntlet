package apps.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * A first example of Scene
 **/
public class GameMenuScene extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception {

        final BorderPane GameMenu = new GameMenuController();

        // Scene dimensions
        double width = 1600, height = 900;

        // Scene = container for all content
        Scene scene = new Scene(GameMenu, width, height);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Gauntlet");
        primaryStage.show ();
    }


    public static void main (String args []) {
        launch (args);
    }
}
