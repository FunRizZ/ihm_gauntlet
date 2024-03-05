package apps.controller;

import apps.mapcreator.MapCreatorScene;
import apps.scoreboard.ScoreboardScene;
import apps.credits.creditsScene;
import apps.setting.SettingCreatorScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class GameMenuController{
    /*
    @FXML
    public void changeGameMenu (ActionEvent event) {
        //Passer par la scene de choix du personnage avant
        GameScene Game = new GameScene();
        Game.changeScene(MapCreator.GAME, MapCreator.SCENE_TITLE);
    }

    @FXML
    public void changeLoadMenu (ActionEvent event) {
        LoadScene Load = new LoadScene();
        Load.changeScene(MapCreator.LOAD, MapCreator.SCENE_TITLE);
    }
    */
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
    public void changeSettingMenu (ActionEvent event) {
        SettingCreatorScene Setting = new SettingCreatorScene();
        Setting.changeScene(Setting.SETTING, Setting.SCENE_TITLE);
    }

    @FXML
    public void changeCreditsMenu (ActionEvent event) {
        creditsScene Credits = new creditsScene();
        Credits.changeScene(Credits.CREDITS, Credits.SCENE_TITLE);
    }

    @FXML
    public void handleQuit(ActionEvent event) {
        System.out.println("You leave the game. Goodbye!");
        Platform.exit();
    }
}