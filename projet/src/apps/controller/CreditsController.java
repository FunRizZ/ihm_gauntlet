package apps.controller;

import apps.game.GameMenuScene;
import apps.mapcreator.MapCreatorScene;
import apps.scoreboard.ScoreboardScene;
import apps.setting.SettingCreatorScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class CreditsController{

    @FXML
    public void goMenu(ActionEvent event) {
        GameMenuScene GameMenu = new GameMenuScene();
        GameMenu.changeScene(GameMenu.GAME_MENU, GameMenu.SCENE_TITLE);
    }
}