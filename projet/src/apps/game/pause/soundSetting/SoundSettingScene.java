package apps.game.pause.soundSetting;

import apps.game.pause.PauseScene;
import javafx.scene.Scene;

public class SoundSettingScene {
    public final SoundSettingLoad MENU;

    /**
     * Definition of the Sound Setting Scene
     */
    public SoundSettingScene (){
        this.MENU = new SoundSettingLoad();
        MENU.init();
    }

    /**
     * Load the Sound Setting Scene
     */
    public void load(){
        double width = PauseScene.pauseStage.getWidth();
        double height = PauseScene.pauseStage.getHeight();

        Scene soundSettingScene = new Scene(MENU);
        PauseScene.pauseStage.setScene(soundSettingScene);
        PauseScene.pauseStage.setTitle("Réglages du son");

        PauseScene.pauseStage.setWidth(width);
        PauseScene.pauseStage.setHeight(height);
    }
    
}
