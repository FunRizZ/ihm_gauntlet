package apps.setting;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class Setting_load extends GridPane {

    public Setting_load() {
        try {
            // Locate the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(Setting_load.class.getResource("Setting.fxml"));

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
