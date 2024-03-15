package apps.mainMenu;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * Loading of Game Menu
 */
public class MainMenuLoad extends BorderPane {
    private final FXMLLoader fxmlLoader;

    /**
     * Load the Game Menu with fxmlLoader
     */
    public MainMenuLoad() {
        fxmlLoader = new FXMLLoader(MainMenuLoad.class.getResource("MainMenu.fxml"), SettingController.language);
    }

    /**
     * Initialize the scene
     */
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