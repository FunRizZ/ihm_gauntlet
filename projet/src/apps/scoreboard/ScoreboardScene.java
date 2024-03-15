package apps.scoreboard;

import apps.MainScene;

/**
 * Create the Scoreboard scene
 **/
public class ScoreboardScene extends MainScene {
    public final String SCENE_TITLE;
    public final ScoreboardLoad SCOREBOARD;

    public ScoreboardScene (){
        super();
        this.SCENE_TITLE = "Hall of Fame";
        this.SCOREBOARD = new ScoreboardLoad();
        this.SCOREBOARD.init();
    }

    /**
     * Load method for the Scoreboard scene
     */
    @Override
    public void load(){
        this.changeScene(SCOREBOARD, this.SCENE_TITLE);
    }
}