package apps.scoreboard;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

/**
 * Class for loading the Scoreboard
 */
public class ScoreboardLoad extends BorderPane {
    private FXMLLoader fxmlLoader;

    /**
     * Load the Scoreboard menu with FxmlLoader
     */
    public ScoreboardLoad() {
        fxmlLoader = new FXMLLoader(ScoreboardLoad.class.getResource("Scoreboard.fxml"),SettingController.language);
    }

    /**
     * Initialize the Scoreboard scene
     */
    public void init() {
        try {
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        }
        catch(IOException ioe) {
            System.err.println("ScoreboardControlleur constructor error");
            ioe.printStackTrace();
        }
    }
}