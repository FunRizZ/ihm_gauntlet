package apps.controller;

import apps.game.GameMenuScene;
import apps.mapcreator.MapCreatorLoad;
import apps.setting.SettingCreatorScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.util.Pair;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class MapCreatorController{
    private int object_select;
    private final Game GAME;
    private double zoom;
    public List<Pair<Location, Button>> maps;
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
    @FXML
    StackPane Img111;
    public MapCreatorController() {
        this.GAME = MapCreatorLoad.GAME;
        this.object_select = -1;
        this.zoom = 1;
        this.maps = new ArrayList<>();
        this.maps.add( new Pair (GAME.getMainHero().getLocation(), new Button(GAME.getMainHero().getLocation().NAME.name())));
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

        Img81.getChildren().add((new Exit(GAME.createLocation(LocationName.GARDEN,12,12), 0, 0)).getSpray());
        Img81.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 81);
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
        Img111.getChildren().add(new Spawn(-1,-1).getSpray());
        Img111.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 111);


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
        if (GAME.getMainHero().getLocation().BOARD[x][y] != null){       /* definition du spray */
            ImageView spray = GAME.getMainHero().getLocation().BOARD[x][y].getSpray();
            image.getChildren().add(spray);
        }
        Map.add(image,x,y);
    }
    public void resetMap(){
        for (int x = 0; x < GAME.SIZE_MAP_X; x++){
            for (int y = 0; y < GAME.SIZE_MAP_y; y++){
                reset(x,y);
            }
        }
    }
    public void changeMap(Location loc){
        for (Pair p : this.maps){
            if (p.getKey().equals(loc)){
                GAME.changeLocation(loc);
                this.resetMap();
            }
        }
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
            case 81 -> {
                LocationName locationName = LocationName.values()[this.maps.size()];
                Location l = GAME.createLocation(locationName, GAME.SIZE_MAP_X, GAME.SIZE_MAP_y);

                Button b = new Button("switch to "+ locationName.name());
                b.setOnAction( e -> {
                    System.out.println("you are in "+ GAME.getMainHero().getLocation().NAME.name());
                    System.out.println("move to " + l.NAME.name());
                    changeMap(l);
                    b.setDisable(true);
                });
                maps.addLast( new Pair (l, b));
                ((HBox)Tab2.getContent()).getChildren().add(b);

                return new Exit(l,x,y);
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
            case 111 -> {
                Spawn sp = new Spawn(x,y);
                GAME.getMainHero().getLocation().SPAWNS.add(sp);
                return sp;
            }
            default -> {return null;}
        }
    }
    public void addLookable(int x, int y){
        System.out.println(this.object_select+" , "+x +" , "+y);
        Lookable l = getLookable(x,y);
        if (l != null){
            GAME.getMainHero().getLocation().addLookable(l);
        }
        else if(GAME.getMainHero().getLocation().BOARD[x][y] != null){
            if (GAME.getMainHero().getLocation().BOARD[x][y] instanceof Exit){

                for (Pair p : this.maps){
                    if (p.getKey().equals( ((Exit) GAME.getMainHero().getLocation().BOARD[x][y]).EXIT_LOCATION)){
                        int pos = ((HBox) Tab2.getContent()).getChildren().indexOf(p.getValue());
                        ((HBox) Tab2.getContent()).getChildren().remove(pos);
                    }
                }
            }
            GAME.getMainHero().getLocation().removeLookable( GAME.getMainHero().getLocation().BOARD[x][y]);
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

    @FXML
    public void SaveMap(ActionEvent event){
        try {
            GAME.getMainHero().getLocation().toFile();
        }catch (Exception e){
            System.err.println("error on SaveMap ");
            e.printStackTrace();
        }

    }

    @FXML
    public void load(ActionEvent event){
       if(GAME.Load("./save/locations/GARDEN.json")){
            this.resetMap();
       }else {
           System.out.println("error on load");
       }
    }
    @FXML
    public void Back(ActionEvent event){
        if (this.maps.size() > 1){
            for (Pair p : this.maps) {
                ((Button) p.getValue()).setDisable(false);
            }
            GAME.changeLocation(this.maps.getFirst().getKey());
            this.resetMap();
        }
    }
}
