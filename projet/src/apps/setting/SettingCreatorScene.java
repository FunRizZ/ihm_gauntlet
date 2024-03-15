package apps.setting;

import apps.MainScene;

/**
 * Class for the scene of the Map creator
 **/
public class SettingCreatorScene extends MainScene {
    public final String SCENE_TITLE;
    public final SettingPageLoad SETTING;

    /**
     * Definition of the Setting Creator Scene
     */
    public SettingCreatorScene (){
        super();
        this.SCENE_TITLE = "Setting";
        this.SETTING = new SettingPageLoad();
        this.SETTING.init();
    }

    /**
     * Load the Settings Scene
     */
    @Override
    public void load(){
        this.changeScene(SETTING, this.SCENE_TITLE);
    }
}
