package apps.controller;

import apps.game.pause.PauseScene;
import apps.game.pause.soundSetting.SoundSettingScene;
import apps.mainMenu.MainMenuScene;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class PauseController {

    /**
     * Save the game
     */
    @FXML
    protected void handleSave() {
        // Ajoutez ici le code pour sauvegarder le jeu
    }

    /**
     * Load the game
     */
    @FXML
    protected void handleLoad() {
        // Ajoutez ici le code pour charger le jeu
    }

    /**
     * open Setting the sound
     */
    @FXML
    protected void handleSettingSound() {
        SoundSettingScene SoundSetting = new SoundSettingScene();
        SoundSetting.load();   
    }

    /**
     * Quit to main menu
     */
    @FXML
    protected void handleQuitToMainMenu() {
        PauseScene.pauseStage.close();
        MainMenuScene GameMenu = new MainMenuScene();
        GameMenu.changeScene(GameMenu.GAME_MENU, GameMenu.SCENE_TITLE);
    }

    /**
     * Quit to desktop
     */
    @FXML
    protected void handleQuitToDesktop() {
        Platform.exit();
    }
}