package apps.mapcreator;

import apps.MainScene;

/**
 * scene of the Map creator
 **/
public class MapCreatorScene extends MainScene {
    public final String SCENE_TITLE;
    public final MapCreatorLoad MAPCREATOR;

    /**
     * Constructor of MapCreator scene
     */
    public MapCreatorScene (){
        super();
        this.SCENE_TITLE = "Map Creator";
        this.MAPCREATOR = new MapCreatorLoad();
        this.MAPCREATOR.init();
    }

    /**
     * Load method for MapCreator
     */
    @Override
    public void load(){
        this.changeScene(MAPCREATOR, this.SCENE_TITLE);
    }
}