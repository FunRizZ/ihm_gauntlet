package apps.game;

import apps.MainScene;

/**
 * scene of the Game menu
 **/
public class GameMenuScene extends MainScene {

    public void GameMenuScene (){
    }
    @Override
    public void load(){
        GameMenuLoad mapCreatorLoad = new GameMenuLoad();

        this.changeScene(mapCreatorLoad, "map creator");
    }
}
