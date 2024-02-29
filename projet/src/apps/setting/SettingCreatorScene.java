package apps.setting;

import apps.MainScene;

/**
 * scene of the Map creator
 **/
public class SettingCreatorScene extends MainScene {
    public final String SCENE_TITLE;
    public final SettingPageLoad SETTING;
    public SettingCreatorScene (){
        super();
        this.SCENE_TITLE = "Setting";
        this.SETTING = new SettingPageLoad();
        this.SETTING.init();
    }
    @Override
    public void load(){
        this.changeScene(SETTING, this.SCENE_TITLE);
    }
}
