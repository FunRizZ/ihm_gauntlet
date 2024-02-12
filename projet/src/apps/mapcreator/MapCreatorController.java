package apps.mapcreator;

import Game_pack.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class MapCreatorController extends BorderPane {
    private final Game GAME;
    @FXML
    GridPane Map;
    public MapCreatorController(Game game) {
        this.GAME = game;
        try {
            // Locate the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(MapCreatorController.class.getResource("MapCreator.fxml"));

            // Since the loaded FXML file is the root of the scene,
            // We must also set the Root as this class
            fxmlLoader.setRoot(this);

            // Actual loading
            fxmlLoader.load();
        }
        catch(IOException ioe) {
            System.err.println("MapCreatorControlleur constructor error");
            //ioe.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        for(int x = 0; x < GAME.SIZE_MAP_X; x++){
            for (int y = 0; y < GAME.SIZE_MAP_y; y++){
                Button button = new Button(x+" , "+y);
                Map.add(button,x,y);
            }
        }
    }
}
