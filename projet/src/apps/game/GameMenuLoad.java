package apps.game;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class GameMenuLoad extends BorderPane {
    private final FXMLLoader fxmlLoader;

    public GameMenuLoad() {
        fxmlLoader = new FXMLLoader(GameMenuLoad.class.getResource("GameMenu.fxml"), SettingController.language);
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