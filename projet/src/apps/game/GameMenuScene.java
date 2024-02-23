package apps.game;

import apps.MainScene;


/**
 * scene of the Game menu
 **/
public class GameMenuScene extends MainScene {
    public final String SCENE_TITLE;
    public final GameMenuLoad GAME_MENU;
    public GameMenuScene (){
        this.SCENE_TITLE = "Menu Gauntlet";
        this.GAME_MENU = new GameMenuLoad();
    }
    @Override
    public void load(){
        this.changeScene(this.GAME_MENU, this.SCENE_TITLE);
    }
}
