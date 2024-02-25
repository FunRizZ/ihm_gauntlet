package apps.scoreboard;

import model.Game_pack.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class ScoreboardLoad extends BorderPane {
    public ScoreboardLoad() {
        try {
            // Locate the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(ScoreboardLoad.class.getResource("Scoreboard.fxml"));

            // Since the loaded FXML file is the root of the scene,
            // We must also set the Root as this class
            fxmlLoader.setRoot(this);
            // Actual loading
            fxmlLoader.load();
        }
        catch(IOException ioe) {
            System.err.println("ScoreboardControlleur constructor error");
            ioe.printStackTrace();
        }
    }
}
