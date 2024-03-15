package apps.credits;

import apps.MainScene;


/**
 * Class for create the Credits scene
 **/
public class creditsScene extends MainScene {
    public final String SCENE_TITLE;
    public final creditsLoad CREDITS;
    public creditsScene(){
        this.SCENE_TITLE = "Credits";
        this.CREDITS = new creditsLoad();
        CREDITS.init();
    }

    /**
     * Load method for the Credits scene
     */
    @Override
    public void load(){
        this.changeScene(this.CREDITS, this.SCENE_TITLE);
    }
}
