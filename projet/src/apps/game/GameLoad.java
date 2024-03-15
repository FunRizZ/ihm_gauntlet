package apps.game;

import apps.controller.SettingController;
import apps.game.selectHero.SelectHeroLoad;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class GameLoad extends BorderPane {
    private final FXMLLoader fxmlLoader;

    /**
     * Load the Select Hero with fxmlLoader
     */
    public GameLoad() {
        fxmlLoader = new FXMLLoader(SelectHeroLoad.class.getResource("Game.fxml"), SettingController.language);
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
