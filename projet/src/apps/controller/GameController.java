package apps.controller;

import apps.game.pause.PauseScene;
import apps.setting.JsonSetting;
import apps.setting.SettingPersonnage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.character.Direction;
import model.character.hero.Hero;
import model.game_pack.Game;

public class GameController extends Pane {
    public final Game GAME;
    public final SettingPersonnage[] SETTINGS;
    @FXML
    GridPane map;
    @FXML
    Label difficulty;
    @FXML
    Label nameLocation;
    @FXML
    Label time;

    public void keyPressedAction(KeyEvent event){
        KeyCode key = event.getCode();
        System.out.println(key);
        if (key == KeyCode.ESCAPE){
            PauseScene box = new PauseScene();
            box.loadNewScene();
        }
        for (int i = 0; i < GAME.NB_HERO; i++) {
            SettingPersonnage setting_personnage = JsonSetting.getSetting(i);
            if (setting_personnage.contain(key)) {
                switch (setting_personnage.getKeyString(key)) {
                    case "UP": {
                        Hero hero = GAME.HEROS.get(i);
                        hero.direction = Direction.TOP;
                        if(hero.getLocation().move(hero)){
                            this.resetMap();
                        }else{
                            System.out.println("impossible move");
                        }
                    }
                    case "DOWN": {
                        Hero hero = GAME.HEROS.get(i);
                        hero.direction = Direction.BOTTOM;
                        if(hero.getLocation().move(hero)){
                            this.resetMap();
                        }else{
                            System.out.println("impossible move");
                        }
                    }
                    case "LEFT": {
                        Hero hero = GAME.HEROS.get(i);
                        hero.direction = Direction.LEFT;
                        if(hero.getLocation().move(hero)){
                            this.resetMap();
                        }else{
                            System.out.println("impossible move");
                        }
                    }
                    case "RIGHT": {
                        Hero hero = GAME.HEROS.get(i);
                        hero.direction = Direction.RIGHT;
                        if(hero.getLocation().move(hero)){
                            this.resetMap();
                        }else{
                            System.out.println("impossible move");
                        }
                    }
                }
            }
        }
    }
    public GameController(){
        this.GAME = Game.GAME;
        this.SETTINGS = JsonSetting.getSetting();
    }
    @FXML
    public void initialize(){
        this.resetMap();
    }
    public void reset(int x, int y){
        Image fondImage = new Image(MapCreatorController.class.getResource("/sprites/floor.png").toExternalForm());
        ImageView fond = new ImageView(fondImage);
        StackPane image = new StackPane(fond);

        if (GAME.getMainHero().getLocation().BOARD[x][y] != null){       /* definition du spray */
            ImageView spray = GAME.getMainHero().getLocation().BOARD[x][y].getSpray();
            image.getChildren().add(spray);
        }
        map.add(image,x,y);
    }
    public void resetMap(){
        map.getChildren().clear();
        for (int x = 0; x < GAME.getMainHero().getLocation().SIZE_X; x++){
            for (int y = 0; y < GAME.getMainHero().getLocation().SIZE_Y; y++){
                reset(x,y);
            }
        }
    }
}
