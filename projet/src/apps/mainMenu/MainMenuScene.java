package apps.mainMenu;

import apps.MainScene;


/**
 * Scene of the Game menu
 **/
public class MainMenuScene extends MainScene {
    public final String SCENE_TITLE;
    public final MainMenuLoad GAME_MENU;

    /**
     * Definition of the Game Menu Scene
     */
    public MainMenuScene(){
        this.SCENE_TITLE = "Menu Gauntlet";
        this.GAME_MENU = new MainMenuLoad();
        GAME_MENU.init();
    }

    /**
     * Load the Game Menu Scene
     */
    @Override
    public void load(){
        this.changeScene(this.GAME_MENU, this.SCENE_TITLE);
    }
}
