package apps.setting;

import apps.MainScene;

/**
 * scene of the Map creator
 **/
public class SettingCreatorScene extends MainScene {
    public final String SCENE_TITLE;
    public final Setting_load SETTING;
    public SettingCreatorScene (){
        super();
        this.SCENE_TITLE = "Setting";
        this.SETTING = new Setting_load();
    }
    @Override
    public void load(){
        this.changeScene(SETTING, this.SCENE_TITLE);
    }
}
