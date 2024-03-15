package apps.game;

import apps.MainScene;
import apps.game.selectHero.SelectHeroLoad;

public class GameScene extends MainScene {
    public final String SCENE_TITLE;
    public final GameLoad MENU;

    /**
     * Definition of the Select Hero Scene
     */
    public GameScene (){
        this.SCENE_TITLE = "Gauntlet";
        this.MENU = new GameLoad();
        MENU.init();
    }

    /**
     * Load the Game
     */
    @Override
    public void load(){
        this.load();
    }
}
