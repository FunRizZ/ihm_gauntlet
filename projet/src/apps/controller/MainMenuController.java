package apps.controller;

import apps.game.selectHero.SelectHeroScene;
import apps.mapcreator.MapCreatorScene;
import apps.scoreboard.ScoreboardScene;
import apps.credits.creditsScene;
import apps.setting.SettingCreatorScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Class Controller for the Game Menu
 */
public class MainMenuController {
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
        MapCreator.load();
    }

    @FXML
    public void changeScoreboardMenu (ActionEvent event) {
        ScoreboardScene Scoreboard = new ScoreboardScene();
        Scoreboard.load();
    }

    @FXML
    public void changeSettingMenu (ActionEvent event) {
        SettingCreatorScene Setting = new SettingCreatorScene();
        Setting.load();
    }

    @FXML
    public void changeCreditsMenu (ActionEvent event) {
        creditsScene Credits = new creditsScene();
        Credits.load();
    }
    @FXML
    public void newGame(ActionEvent event){
        SelectHeroScene heroChoice = new SelectHeroScene();
        heroChoice.load();
    }

    @FXML
    public void handleQuit(ActionEvent event) {
        System.out.println("You leave the game. Goodbye!");
        Platform.exit();
    }
}