package apps.controller;

import apps.game.GameMenuScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ScoreboardController {


    @FXML
    public void changeGameMenu (ActionEvent event) {
        GameMenuScene gameMenu = new GameMenuScene();
        gameMenu.changeScene(gameMenu.GAME_MENU, gameMenu.SCENE_TITLE);
    }
}
