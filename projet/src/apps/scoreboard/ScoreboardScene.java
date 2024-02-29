package apps.scoreboard;

import apps.MainScene;

/**
 * scene of the Scoreboard / Hall of Fame
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
    @Override
    public void load(){
        this.changeScene(SCOREBOARD, this.SCENE_TITLE);
    }
}