package apps.game;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class GameMenuLoad extends BorderPane {
    private FXMLLoader fxmlLoader;

    public GameMenuLoad() {
        fxmlLoader = new FXMLLoader(GameMenuLoad.class.getResource("GameMenu.fxml"));
    }

    public void init() {
        try {
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch(IOException ioe) {
            System.err.println("GameMenu constructor error");
            ioe.printStackTrace();
        }
    }
}