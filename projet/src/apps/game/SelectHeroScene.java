package apps.game;

import apps.MainScene;

public class SelectHeroScene extends MainScene {
    public final String SCENE_TITLE;
    public final SelectHeroLoad MENU;
    public SelectHeroScene (){
        this.SCENE_TITLE = "Menu Gauntlet";
        this.MENU = new SelectHeroLoad();
        MENU.init();
    }
    @Override
    public void load(){
        this.changeScene(this.MENU, this.SCENE_TITLE);
    }
}
