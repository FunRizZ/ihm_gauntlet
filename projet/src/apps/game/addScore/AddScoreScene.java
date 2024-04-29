package apps.game.addScore;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddScoreScene{
    public final AddScoreLoad MENU;
    public static Stage AddScoreStage;

    public AddScoreScene() {
        MENU = new AddScoreLoad();
        MENU.init();
    }

    public void load() {
        Scene AddScoreScene = new Scene(MENU, 300, 300);
        AddScoreStage = new Stage();
        AddScoreStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        AddScoreStage.setScene(AddScoreScene);
        AddScoreStage.setTitle("Add Score");
        AddScoreStage.show();
    }
}