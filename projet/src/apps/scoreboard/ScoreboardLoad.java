package apps.scoreboard;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class ScoreboardLoad extends BorderPane {
    private FXMLLoader fxmlLoader;

    public ScoreboardLoad() {
        fxmlLoader = new FXMLLoader(ScoreboardLoad.class.getResource("Scoreboard.fxml"));
    }

    public void init() {
        try {
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        }
        catch(IOException ioe) {
            System.err.println("ScoreboardControlleur constructor error");
            ioe.printStackTrace();
        }
    }
}