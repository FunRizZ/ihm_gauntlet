package apps.mapcreator;

import apps.MainScene;
import model.Game_pack.Game;

/**
 * scene of the Map creator
 **/
public class MapCreatorScene extends MainScene {
    public final String SCENE_TITLE;
    public final MapCreatorLoad MAPCREATOR;
    public MapCreatorScene (){
        super();
        this.SCENE_TITLE = "Map Creator";
        this.MAPCREATOR = new MapCreatorLoad(Game.GAME);
    }
    @Override
    public void load(){
        this.changeScene(MAPCREATOR, this.SCENE_TITLE);
    }
}
