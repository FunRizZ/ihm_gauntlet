package apps.mapcreator;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import apps.controller.MainController;
import apps.game.GameMenuLoad;

public class MapCreatorMenuController extends MainController{
    Scene scene=getScene();
    Stage stage=getStage();

    @FXML    
    public void handleKeyPressed() {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                System.out.println("You go back to the game menu.");
                final BorderPane GameMenu = new GameMenuView();
                changeScene(GameMenu);
            }
        });
    }
}