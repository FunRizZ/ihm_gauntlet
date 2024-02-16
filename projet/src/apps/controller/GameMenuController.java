package apps.controller;

import apps.mapcreator.MapCreatorScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GameMenuController{

    @FXML
    public void handleQuit(ActionEvent event) {
        System.out.println("You leave the game. Goodbye!");
        Platform.exit();
    }

    @FXML
    public void changeCreatorMenu (ActionEvent event) {
        MapCreatorScene MapCreator = new MapCreatorScene();
        MapCreator.changeScene(MapCreator.MAPCREATOR, MapCreator.SCENE_TITLE);
    }
}