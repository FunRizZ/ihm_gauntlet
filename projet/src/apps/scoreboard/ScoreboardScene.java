package apps.scoreboard;

import apps.MainScene;
import apps.game.GameMenuLoad;
import apps.mapcreator.MapCreatorLoad;
import model.Game_pack.Game;

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
    }
    @Override
    public void load(){
        this.changeScene(SCOREBOARD, this.SCENE_TITLE);
    }
}