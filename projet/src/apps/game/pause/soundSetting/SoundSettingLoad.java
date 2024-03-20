package apps.game.pause.soundSetting;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class SoundSettingLoad extends BorderPane {
    private final FXMLLoader fxmlLoader;

    /**
     * Load the Sound Setting with fxmlLoader
     */
    public SoundSettingLoad() {
        fxmlLoader = new FXMLLoader(this.getClass().getResource("SoundSetting.fxml"), SettingController.language);
    }

    /**
     * Initialize the scene
     */
    public void init() {
        try {
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch(Exception ioe) {
            System.err.println("SoundSettingLoad constructor error");
            ioe.printStackTrace();
        }
    }
    
}
