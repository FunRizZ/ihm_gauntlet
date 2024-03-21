package apps.controller;

import apps.game.pause.PauseScene;
import apps.game.pause.soundSetting.SoundManager;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class SoundSettingController {

    @FXML
    private Slider volumeSlider;

    @FXML
    public void initialize(){
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double volume = newValue.doubleValue() / 100.0; // Assuming the slider range is 0-100
            SoundManager.setVolume(volume);
        });
    }

    /**
     * Toggles the music on/off
     */
    @FXML
    protected void handleToggleMusic() {
        if (SoundManager.isPlaying()) {
            SoundManager.pause();
        } else {
            SoundManager.play();
        }
    }


    /**
     * Toggles the sound on/off
     */
    @FXML
    protected void handleToggleSound() {
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