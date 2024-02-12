package apps.controller;

import apps.game.GameMenuLoad;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MapCreatorMenuController extends MainController {
    Scene scene = getScene();
    Stage stage = getStage();

    @FXML    
    public void handleKeyPressed() {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                System.out.println("You go back to the game menu.");
                final BorderPane GameMenu = new GameMenuLoad();
                changeScene(GameMenu);
            }
        });
    }
}