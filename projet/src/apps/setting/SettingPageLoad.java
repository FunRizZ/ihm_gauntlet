package apps.setting;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class SettingPageLoad extends BorderPane {
    private FXMLLoader fxmlLoader;

    public SettingPageLoad() {
        fxmlLoader = new FXMLLoader(SettingPageLoad.class.getResource("Setting.fxml"), SettingController.language);
    }

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