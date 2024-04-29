package apps.game.addScore;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class AddScoreLoad extends BorderPane{
        private final FXMLLoader fxmlLoader;

        /**
         * Load the Pause with fxmlLoader
         */
        public AddScoreLoad() {
            fxmlLoader = new FXMLLoader(this.getClass().getResource("AddScore.fxml"), SettingController.language);
        }

        /**
         * Initialize the scene
         */
        public void init() {
            try {
                fxmlLoader.setRoot(this);
                fxmlLoader.load();
            } catch(Exception ioe) {
                System.err.println("AddScoreLoad constructor error");
                ioe.printStackTrace();
            }
        }
}
