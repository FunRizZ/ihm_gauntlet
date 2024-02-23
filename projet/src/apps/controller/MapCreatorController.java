package apps.controller;

import apps.game.GameMenuScene;
import apps.mapcreator.MapCreatorLoad;
import apps.setting.SettingCreatorScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import model.Character.*;
import model.Game_pack.Game;
import model.Game_pack.Lookable;
import model.Item.PoisonPotion;
import model.Location.*;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class MapCreatorController extends BorderPane{
    private int object_select;
    private final Game GAME;
    private double zoom;
    @FXML
    BorderPane Root;
    @FXML
    GridPane Map;
    @FXML
    TabPane MapTabPane;
    @FXML
    Tab Tab1;
    @FXML
    Tab Tab2;
    @FXML
    Tab Tab3;
    @FXML
    Tab Tab4;
    @FXML
    Tab Tab5;
    @FXML
    Tab Tab6;
    @FXML
    Tab Tab7;
    @FXML
    Tab Tab8;
    @FXML
    Tab Tab9;
    @FXML
    Tab Tab10;
    @FXML
    Tab Tab11;

    @FXML
    Button Delete;
    @FXML
    StackPane Img31;
    @FXML
    StackPane Img32;
    @FXML
    StackPane Img41;
    @FXML
    StackPane Img61;
    @FXML
    StackPane Img71;
    @FXML
    StackPane Img81;
    @FXML
    StackPane Img91;
    @FXML
    StackPane Img101;
    @FXML
    StackPane Img102;
    @FXML
    StackPane Img103;
    @FXML
    StackPane Img104;
    @FXML
    StackPane Img105;
    public MapCreatorController() {
        this.GAME = MapCreatorLoad.GAME;
        this.object_select = -1;
        this.zoom = 1;
    }
    @FXML
    public void initialize(){
        this.generate();
        MapTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Img31.getChildren().add((new HealPotionView(-1,-1)).getSpray());
        Img31.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 31);
        Img32.getChildren().add((new PoisonPotionView(-1,-1)).getSpray());
        Img32.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 31);
        Img41.getChildren().add((new HolyGrenadeView(-1,-1)).getSpray());
        Img41.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 41);
        Img61.getChildren().add((new FoodView(-1,-1)).getSpray());
        Img61.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 61);
        Img71.getChildren().add((new Wall(-1,-1)).getSpray());
        Img71.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 71);
        //TODO : faire Exit + key
//        Img81.getChildren().add((new PotionView(-1,-1)).getSpray());
//        Img81.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 71);
        Img91.getChildren().add((new TreasureView(-1,-1)).getSpray());
        Img91.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 91);
        Img101.getChildren().add((new Death(-1,-1)).getSpray());
        Img101.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 101);
        Img102.getChildren().add((new Daemon(-1,-1)).getSpray());
        Img102.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 102);
        Img103.getChildren().add((new Ghost(-1,-1)).getSpray());
        Img103.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 103);
        Img104.getChildren().add((new Grunt(-1,-1)).getSpray());
        Img104.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 104);
        Img105.getChildren().add((new Lobber(-1,-1)).getSpray());
        Img105.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 105);


        Delete.setOnAction(event -> this.object_select = -1);
    }

    /**
     * initialize the gridPane Map with the Hero's location
     */
    public void generate() {
        for(int x = 0; x < GAME.SIZE_MAP_X; x++){
            for (int y = 0; y < GAME.SIZE_MAP_y; y++){
                reset(x,y);
            }
        }
        Map.setStyle("-fx-background-color : black;");
    }

    /**
     * @param x position on the columns
     * @param y position on the rows
     * reset cell on position x, y of the GribPane name Map
     */
    public void reset(int x, int y){
        Image fondImage = new Image(MapCreatorController.class.getResource("/sprites/floor.png").toExternalForm());
        ImageView fond = new ImageView(fondImage);
        StackPane image = new StackPane(fond);

        image.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> addLookable(GridPane.getColumnIndex(image),GridPane.getRowIndex(image)));
        if (GAME.HERO.getLocation().BOARD[x][y] != null){       /* definition du spray */
            ImageView spray = GAME.HERO.getLocation().BOARD[x][y].getSpray();
            //TODO : Modifier ça pour s'adapter aux spawn voulus des joueurs
            image.getChildren().add(spray);
        }
        Map.add(image,x,y);
    }
    public Lookable getLookable(int x, int y){
        switch (this.object_select){
            case 31 -> {
                return new HealPotionView(x,y);
            }
            case 32 -> {
                return new PoisonPotionView(x,y);
            }
            case 41 -> {
                return new HolyGrenadeView(x,y);
            }
            case 61 -> {
                return new FoodView(x,y);
            }
            case 71 -> {
                return new Wall(x,y);
            }
            case 91 -> {
                return new TreasureView(x,y);
            }
            case 101 -> {
                return new Death(x,y);
            }
            case 102 -> {
                return new Daemon(x,y);
            }
            case 103 -> {
                return new Ghost(x,y);
            }
            case 104 -> {
                return new Grunt(x,y);
            }
            case 105 -> {
                return new Lobber(x,y);
            }
            default -> {return null;}
        }
    }
    public void addLookable(int x, int y){
        System.out.println(this.object_select+" , "+x +" , "+y);
        Lookable l = getLookable(x,y);
        if (l != null){
            GAME.HERO.getLocation().addLookable(l);
        }
        else if(GAME.HERO.getLocation().BOARD[x][y] != null){
            GAME.HERO.getLocation().removeLookable( GAME.HERO.getLocation().BOARD[x][y]);
        }
        reset(x, y);
    }
    @FXML
    public void handleQuit(ActionEvent event) {
        System.out.println("You leave the game. Goodbye!");
        Platform.exit();
    }

    @FXML
    public void changeGameMenu (ActionEvent event) {
        GameMenuScene gameMenu = new GameMenuScene();
        gameMenu.changeScene(gameMenu.GAME_MENU, gameMenu.SCENE_TITLE);
    }

    @FXML
    public void changeSetting (ActionEvent event) {
        SettingCreatorScene Setting = new SettingCreatorScene();
        Setting.changeScene(Setting.SETTING, Setting.SCENE_TITLE);
    }

    @FXML
    public void dezoom(KeyEvent event){
        System.out.println(zoom);
        if(zoom > 0){zoom = zoom - 0.001;}
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.1),Map);
        scaleTransition.setToX(zoom); // échelle horizontale
        scaleTransition.setToY(zoom); // échelle verticale
        scaleTransition.play();
    }

}
