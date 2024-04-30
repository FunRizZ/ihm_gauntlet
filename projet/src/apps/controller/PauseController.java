package apps.controller;

import apps.game.pause.PauseScene;
import apps.game.pause.soundSetting.SoundManager;
import apps.game.pause.soundSetting.SoundSettingScene;
import apps.mainMenu.MainMenuScene;
import javafx.fxml.FXML;

public class PauseController {

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
        SoundManager.stop();
        GameController.service.shutdown();
    }

    /**
     * Quit to desktop
     */
    @FXML
    protected void handleQuitToDesktop() {
        MainMenuController.handlequitToDesktop();
    }
}