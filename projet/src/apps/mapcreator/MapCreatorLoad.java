package apps.mapcreator;

import apps.controller.SettingController;
import model.game_pack.Game;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class MapCreatorLoad extends BorderPane {
    public static final Game GAME = Game.GAME;

    private FXMLLoader fxmlLoader;

    /**
     * Load the MapCreator menu with FXMLLOADER
     */
    public MapCreatorLoad() {
        fxmlLoader = new FXMLLoader(MapCreatorLoad.class.getResource("MapCreator.fxml"), SettingController.language);
    }

    /**
     * Initialize the MapCreator scene
     */
    public void init() {
        try {
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch(IOException ioe) {
            System.err.println("MapCreatorControlleur constructor error");
            ioe.printStackTrace();
        }
    }
}
