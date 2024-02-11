package apps.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import projet.src.apps.MainController;
import apps.mapcreator.MapCreatorMenuLoad;


public class GameMenuController extends MainController{
    Scene scene=getScene();
    Stage stage=getStage();

    @FXML
    public void handleQuit(ActionEvent event) {
        System.out.println("You leave the game. Goodbye!");
        Platform.exit();
    }

    @FXML
    public void changeCreatorMenu (ActionEvent event) {
        final BorderPane MapCreator = new MapCreatorMenuController();
        changeScene(MapCreator);
        MapCreatorMenuController mapCreatorMenuController = new MapCreatorMenuController();
        mapCreatorMenuController.handleKeyPressed();
    }
}
