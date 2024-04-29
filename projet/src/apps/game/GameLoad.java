package apps.game;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class GameLoad extends Pane {
    private final FXMLLoader fxmlLoader;

    /**
     * Load the Select Hero with fxmlLoader
     */
    public GameLoad() {
        fxmlLoader = new FXMLLoader(this.getClass().getResource("Game.fxml"), SettingController.language);
    }

    /**
     * Initialize the scene
     */
    public void init() {
        try {
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch(Exception ioe) {
            System.err.println("SelectHeroLoad constructor error");
            ioe.printStackTrace();
        }
    }
}
