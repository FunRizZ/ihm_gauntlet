package apps.game.pause;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class PauseLoad extends BorderPane{
        private final FXMLLoader fxmlLoader;

        /**
         * Load the Pause with fxmlLoader
         */
        public PauseLoad() {
            fxmlLoader = new FXMLLoader(this.getClass().getResource("Pause.fxml"), SettingController.language);
        }

        /**
         * Initialize the scene
         */
        public void init() {
            try {
                fxmlLoader.setRoot(this);
                fxmlLoader.load();
            } catch(Exception ioe) {
                System.err.println("PauseLoad constructor error");
                ioe.printStackTrace();
            }
        }
}
