package projet.src.apps.game;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class GameMenuLoad extends BorderPane {

    public GameMenuLoad() {
        try {
            // Locate the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(GameMenuLoad.class.getResource("GameMenu.fxml"));

            // Since the loaded FXML file is the root of the scene,
            // We must also set the Root as this class
            fxmlLoader.setRoot(this);

            // Actual loading
            fxmlLoader.load();
        }
        catch(IOException ioe) {
            System.err.println("GameMenu constructor error");
            ioe.printStackTrace();
        }
    }
}
