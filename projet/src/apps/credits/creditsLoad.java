package apps.credits;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class creditsLoad extends BorderPane {
    private final FXMLLoader fxmlLoader;

    /**
     * Load the Credits menu with FXMLLOADER
     */
    public creditsLoad() {
        fxmlLoader = new FXMLLoader(creditsLoad.class.getResource("credits.fxml"), SettingController.language);
    }

    /**
     * Initialize the Credits scene
     */
    public void init() {
        try {
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch(IOException ioe) {
            System.err.println("credits constructor error");
            ioe.printStackTrace();
        }
    }
}