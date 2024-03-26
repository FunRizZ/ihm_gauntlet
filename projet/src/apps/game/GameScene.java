package apps.game;

import apps.MainScene;
import apps.controller.GameController;
import apps.game.pause.PauseScene;
import apps.setting.JsonSetting;
import apps.setting.SettingPersonnage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.character.hero.Hero;
import model.game_pack.Game;

public class GameScene extends MainScene {
    public final String SCENE_TITLE;
    public final GameLoad MENU;
    private final Game GAME;

    /**
     * Definition of the Select Hero Scene
     */
    public GameScene (){
        this.SCENE_TITLE = "Gauntlet";
        this.MENU = new GameLoad();
        MENU.init();
        GAME = Game.GAME;
    }

    /**
     * Load the Game
     */
    @Override
    public void load(){
        this.changeScene(this.MENU, this.SCENE_TITLE);
    }
}
