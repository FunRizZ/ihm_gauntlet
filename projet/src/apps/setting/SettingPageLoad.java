package apps.setting;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

/**
 * Class for Loading Settings Scene
 */
public class SettingPageLoad extends BorderPane {
    private final FXMLLoader fxmlLoader;

    /**
     * Load the Settings Scene with fxmlLoader
     */
    public SettingPageLoad() {
        fxmlLoader = new FXMLLoader(SettingPageLoad.class.getResource("Setting.fxml"), SettingController.language);
    }

    /**
     * Initialize the scene
     */
    public void init() {
        try {
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        }
        catch(IOException ioe) {
            System.err.println("SettingPageLoad constructor error");
            ioe.printStackTrace();
        }
    }
}