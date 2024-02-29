package apps.controller;

import apps.mapcreator.MapCreatorScene;
import apps.scoreboard.ScoreboardScene;
import apps.setting.SettingCreatorScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


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

    @FXML
    public void changeScoreboardMenu (ActionEvent event) {
        ScoreboardScene Scoreboard = new ScoreboardScene();
        Scoreboard.changeScene(Scoreboard.SCOREBOARD, Scoreboard.SCENE_TITLE);
    }

    @FXML
    public void changeSetting (ActionEvent event) {
        SettingCreatorScene Setting = new SettingCreatorScene();
        Setting.changeScene(Setting.SETTING, Setting.SCENE_TITLE);
    }

}