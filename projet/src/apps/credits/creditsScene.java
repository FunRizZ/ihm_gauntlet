package apps.credits;

import apps.MainScene;


/**
 * scene of the Game menu
 **/
public class creditsScene extends MainScene {
    public final String SCENE_TITLE;
    public final creditsLoad CREDITS;
    public creditsScene(){
        this.SCENE_TITLE = "Credits";
        this.CREDITS = new creditsLoad();
        CREDITS.init();
    }
    @Override
    public void load(){
        this.changeScene(this.CREDITS, this.SCENE_TITLE);
    }
}
