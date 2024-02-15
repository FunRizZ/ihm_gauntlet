package apps.mapcreator;

import Game_pack.Game;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class MapCreator extends BorderPane{
    public static final Game GAME= Game.GAME;
    public MapCreator(Game game) {
        try {
            // Locate the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(MapCreator.class.getResource("MapCreator.fxml"));

            // Since the loaded FXML file is the root of the scene,
            // We must also set the Root as this class
            fxmlLoader.setRoot(this);
            // Actual loading
            fxmlLoader.load();
        }
        catch(IOException ioe) {
            System.err.println("MapCreatorControlleur constructor error");
            ioe.printStackTrace();
        }
    }

}
