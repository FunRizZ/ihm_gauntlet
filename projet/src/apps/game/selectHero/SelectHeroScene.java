package apps.game.selectHero;

import apps.MainScene;
import apps.game.selectHero.SelectHeroLoad;

/**
 * Set the Select Hero Scene
 */
public class SelectHeroScene extends MainScene {
    public final String SCENE_TITLE;
    public final SelectHeroLoad MENU;

    /**
     * Definition of the Select Hero Scene
     */
    public SelectHeroScene (){
        this.SCENE_TITLE = "Menu Gauntlet";
        this.MENU = new SelectHeroLoad();
        MENU.init();
    }

    /**
     * Load the Select Hero Scene
     */
    @Override
    public void load(){
        this.changeScene(this.MENU, this.SCENE_TITLE);
    }
}
