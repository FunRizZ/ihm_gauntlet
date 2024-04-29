package apps.controller;

import apps.game.addScore.AddScoreScene;
import apps.game.pause.soundSetting.SoundManager;
import apps.mainMenu.MainMenuScene;
import apps.scoreboard.Scoreboard;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.time.LocalDate;

public class AddScoreController {

    @FXML
    private Label scoreLabel;

    @FXML
    private TextField pseudoField;

    @FXML
    protected void handleSaveScore() {
        String pseudo = pseudoField.getText();
        Scoreboard.addScore(pseudo, GameController.Score, LocalDate.now());
        AddScoreScene.AddScoreStage.close();
        MainMenuScene GameMenu = new MainMenuScene();
        GameMenu.changeScene(GameMenu.GAME_MENU, GameMenu.SCENE_TITLE);
        SoundManager.stop();
    }
    @FXML
    public void initialize(){
        int x = GameController.Score;
        String texte = scoreLabel.getText();
        scoreLabel.setText(texte+x);
    }
}