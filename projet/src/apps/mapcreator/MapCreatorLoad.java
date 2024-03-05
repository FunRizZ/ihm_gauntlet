package apps.mapcreator;

import apps.controller.SettingController;
import model.game_pack.Game;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class MapCreatorLoad extends BorderPane {
    public static final Game GAME = Game.GAME;

    private FXMLLoader fxmlLoader;

    public MapCreatorLoad(Game game) {
        fxmlLoader = new FXMLLoader(MapCreatorLoad.class.getResource("MapCreator.fxml"), SettingController.language);
    }

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
