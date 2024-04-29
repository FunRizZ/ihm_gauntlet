package apps.game;

import apps.MainScene;
import model.game_pack.Game;

public class GameScene extends MainScene {
    public final String SCENE_TITLE;
    public final GameLoad MENU;
    private final Game GAME;

    /**
     * Definition of the Select Hero Scene
     */
    public GameScene (){
        this.SCENE_TITLE = "Gauntlet";
        this.MENU = new GameLoad();
        MENU.init();
        GAME = Game.GAME;
    }

    /**
     * Load the Game
     */
    @Override
    public void load(){
        this.changeScene(this.MENU, this.SCENE_TITLE);
    }
}
