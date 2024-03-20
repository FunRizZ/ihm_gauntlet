package apps.controller;

import apps.game.pause.PauseScene;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class SoundSettingController {

    @FXML
    private Slider volumeSlider;

    /**
     * Toggles the sound on/off
     */
    @FXML
    protected void handleToggleSound() {
        // Add code here to toggle sound on/off
    }

    /**
     * Toggles the music on/off
     */
    @FXML
    protected void handleToggleMusic() {
        // Add code here to toggle music on/off
    }

    /**
     * Returns to the pause menu
     */
    @FXML
    protected void handleBack() {
        PauseScene pauseScene = new PauseScene();
        pauseScene.load();
    }
}