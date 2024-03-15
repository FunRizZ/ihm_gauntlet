package apps.controller;

import apps.game.GameMenuScene;
import apps.mapcreator.MapCreatorLoad;
import apps.setting.SettingCreatorScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.util.Pair;
import model.character.monster.*;
import model.game_pack.Game;
import model.game_pack.Lookable;
import model.location.*;
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
import model.location.decorObject.*;

import java.util.ArrayList;
import java.util.List;

import static apps.controller.EntitiesEnum.*;

public class MapCreatorController{
    private EntitiesEnum object_select;
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
    StackPane Img33;
    @FXML
    StackPane Img34;
    @FXML
    StackPane Img35;
    @FXML
    StackPane Img41;
    @FXML
    StackPane Img51;
    @FXML
    StackPane Img61;
    @FXML
    StackPane Img71;
    @FXML
    StackPane Img72;
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
    StackPane Img106;
    @FXML
    StackPane Img107;
    @FXML
    StackPane Img111;

    /**
     * Constructor of the Map Creator
     */
    public MapCreatorController() {
        this.GAME = MapCreatorLoad.GAME;
        this.object_select = DELETE;
        this.zoom = 1;
        this.maps = new ArrayList<>();
        this.maps.add( new Pair<> (GAME.getMainHero().getLocation(), new Button(GAME.getMainHero().getLocation().NAME.name())));
    }

    /**
     * Method that initialize the grid of the Map Creator
     */
    @FXML
    public void initialize(){
        this.generate();
        MapTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Img31.getChildren().add((new HealPotionView(-1,-1)).getSpray());
        Img31.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = HEAL_POTION);
        Img32.getChildren().add((new PoisonPotionView(-1,-1)).getSpray());
        Img32.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = POISON_POTION);
        Img33.getChildren().add((new DefensePotionView(-1,-1)).getSpray());
        Img33.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = DEFENSE_POTION);
        Img34.getChildren().add((new AttackPotionView(-1,-1)).getSpray());
        Img34.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = ATTACK_POTION);
        Img35.getChildren().add((new MagicPotionView(-1,-1)).getSpray());
        Img35.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = MAGIC_POTION);

        Img41.getChildren().add((new HolyGrenadeView(-1,-1)).getSpray());
        Img41.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = HOLY_GRENADE);

        Img51.getChildren().add((new KeyView(-1,-1)).getSpray());
        Img51.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = KEY);

        Img61.getChildren().add((new FoodView(-1,-1)).getSpray());
        Img61.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = FOOD);

        Img71.getChildren().add((new Wall(-1,-1)).getSpray());
        Img71.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = WALL);
        Img72.getChildren().add((new Door(-1,-1,9)).getSpray());
        Img72.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = DOOR);

        Img81.getChildren().add((new Exit(GAME.createLocation(LocationName.GARDEN,12,12), 0, 0)).getSpray());
        Img81.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = EXIT);

        Img91.getChildren().add((new TreasureView(-1,-1)).getSpray());
        Img91.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = TREASURE);

        Img101.getChildren().add((new Death(-1,-1)).getSpray());
        Img101.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = DEATH);
        Img102.getChildren().add((new Daemon(-1,-1)).getSpray());
        Img102.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = DAEMON);
        Img103.getChildren().add((new Ghost(-1,-1)).getSpray());
        Img103.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = GHOST);
        Img104.getChildren().add((new Grunt(-1,-1)).getSpray());
        Img104.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = GRUNT);
        Img105.getChildren().add((new Lobber(-1,-1)).getSpray());
        Img105.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = LOBBER);
        Img106.getChildren().add(new Spawner_Grunt(-1,-1).getSpray());
        Img106.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = SPAWNER_GRUNT);
        Img107.getChildren().add((new Spawner_Ghost(-1,-1)).getSpray());
        Img107.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = SPAWNER_GHOST);

        Img111.getChildren().add(new Spawn(-1,-1).getSpray());
        Img111.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = SPAWN_HERO);

        Delete.setOnAction(event -> this.object_select = DELETE);
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

    /**
     * Method that reset the entire map
     */
    public void resetMap(){
        for (int x = 0; x < GAME.getMainHero().getLocation().SIZE_X; x++){
            for (int y = 0; y < GAME.getMainHero().getLocation().SIZE_Y; y++){
                reset(x,y);
            }
        }
    }

    /**
     * Method that change the Map
     * @param loc the map you choose for the change
     */
    public void changeMap(Location loc){
        for (Pair<Location, Button> p : this.maps){
            if (p.getKey().equals(loc)){
                GAME.changeLocation(loc);
                this.resetMap();
            }
        }
    }
    //TODO : Nath fait la doc stp xD
    public Button creatExitButton(Location location){
        Button b = new Button("switch to "+ location.NAME.name());
        b.setOnAction( e -> {
            System.out.println("you are in "+ GAME.getMainHero().getLocation().NAME.name());
            System.out.println("move to " + location.NAME.name());
            changeMap(location);
            b.setDisable(true);
        });
        ((HBox)Tab2.getContent()).getChildren().add(b);
        maps.addLast( new Pair<>(location, b));
        return b;
    }

    /**
     * Associate the right view for each case at position
     * @param x
     * @param y
     * @return the association of the view in the case (x,y)
     */
    public Lookable getLookable(int x, int y){
        switch (this.object_select){
            case HEAL_POTION -> {
                return new HealPotionView(x,y);
            }
            case POISON_POTION -> {
                return new PoisonPotionView(x,y);
            }
            case DEFENSE_POTION -> {
                return new DefensePotionView(x,y);
            }
            case ATTACK_POTION -> {
                return new AttackPotionView(x,y);
            }
            case MAGIC_POTION -> {
                return new MagicPotionView(x,y);
            }
            case HOLY_GRENADE -> {
                return new HolyGrenadeView(x,y);
            }
            case KEY -> {
                return new KeyView(x,y);
            }
            case FOOD -> {
                return new FoodView(x,y);
            }
            case WALL -> {
                return new Wall(x,y);
            }
            case DOOR -> {
                return new Door(x,y);
            }
            case EXIT -> {
                LocationName locationName = LocationName.values()[this.maps.size()];
                Location l = GAME.createLocation(locationName, GAME.SIZE_MAP_X, GAME.SIZE_MAP_y);

                this.creatExitButton(l);

                return new Exit(l,x,y);
            }
            case TREASURE -> {
                return new TreasureView(x,y);
            }
            case DEATH -> {
                return new Death(x,y);
            }
            case DAEMON -> {
                return new Daemon(x,y);
            }
            case GHOST -> {
                return new Ghost(x,y);
            }
            case GRUNT -> {
                return new Grunt(x,y);
            }
            case LOBBER -> {
                return new Lobber(x,y);
            }
            case SPAWNER_GRUNT -> {
                return new Spawner_Grunt(x,y);
            }
            case SPAWNER_GHOST -> {
                return new Spawner_Ghost(x,y);
            }
            case SPAWN_HERO -> {
                Spawn sp = new Spawn(x,y);
                GAME.getMainHero().getLocation().SPAWNS.add(sp);
                return sp;
            }
            default -> {return null;}
        }
    }

    /**
     * Add the view to the case (x,y)
     * @param x
     * @param y
     */
    public void addLookable(int x, int y){
        System.out.println(this.object_select+" , "+x +" , "+y);
        Lookable l = getLookable(x,y);
        if (l != null){
            GAME.getMainHero().getLocation().addLookable(l);
        }
        else if(GAME.getMainHero().getLocation().BOARD[x][y] != null){
            if (GAME.getMainHero().getLocation().BOARD[x][y] instanceof Exit){

                for (Pair<Location, Button> p : this.maps){
                    if (p.getKey().equals( ((Exit) GAME.getMainHero().getLocation().BOARD[x][y]).EXIT_LOCATION)){
                        ((HBox) Tab2.getContent()).getChildren().remove(p.getValue());
                    }
                }
            }
            GAME.getMainHero().getLocation().removeLookable( GAME.getMainHero().getLocation().BOARD[x][y]);
        }
        reset(x, y);
    }

    /**
     * Quit the game
     */
    @FXML
    public void handleQuit() {
        System.out.println("You leave the game. Goodbye!");
        Platform.exit();
    }

    /**
     * Change the actual scene to the Main Menu scene
     */
    @FXML
    public void changeGameMenu() {
        GameMenuScene gameMenu = new GameMenuScene();
        gameMenu.changeScene(gameMenu.GAME_MENU, gameMenu.SCENE_TITLE);
    }

    /**
     * Change the actual scene to the Settings scene
     */
    @FXML
    public void changeSetting() {
        SettingCreatorScene Setting = new SettingCreatorScene();
        Setting.changeScene(Setting.SETTING, Setting.SCENE_TITLE);
    }

    /**
     * Make a dezoom
     */
    @FXML
    public void dezoom(){
        System.out.println(zoom);
        if(zoom > 0){zoom = zoom - 0.001;}
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.1),Map);
        scaleTransition.setToX(zoom); // échelle horizontale
        scaleTransition.setToY(zoom); // échelle verticale
        scaleTransition.play();
    }

    /**
     * Save the map
     */
    @FXML
    public void SaveMap(){
        try {
            GAME.getMainHero().getLocation().toFile();
        }catch (Exception e){
            System.err.println("error on SaveMap ");
            e.printStackTrace();
        }

    }

    /**
     * Create buttons for each exits of the map
     * @param location the actual map
     * @param exits the list of exits in the map
     */
    private void parcoursAllExits(Location location, List<Exit> exits){
        if (exits.isEmpty()){
            this.creatExitButton(location);
        }
        else{
            for (Exit exit: exits){
                parcoursAllExits(exit.EXIT_LOCATION, exit.EXIT_LOCATION.getExits());
            }
            this.creatExitButton(location);
        }
    }

    /**
     * Load a map
     */
    @FXML
    public void load(){
        if(GAME.Load("./save/locations/GARDEN.json")){
            this.resetMap();
            for (Pair<Location, Button> p : this.maps) {
                ((HBox) Tab2.getContent()).getChildren().remove(p.getValue());
            }
            this.maps.clear();
            this.maps.add( new Pair<> (GAME.getMainHero().getLocation(), new Button(GAME.getMainHero().getLocation().NAME.name())));
            parcoursAllExits(GAME.getMainHero().getLocation(), GAME.getMainHero().getLocation().getExits());

            for (Pair<Location, Button> p : this.maps) { /* supprime le bouton pour revenir au depart */
                if( p.getKey() == GAME.getMainHero().getLocation()){
                    ((HBox) Tab2.getContent()).getChildren().remove(p.getValue());
                }
            }
        }else {
            System.out.println("error on load");
        }
    }

    //TODO Nath, fais la doc de cette fonction stp
    @FXML
    public void Back(){
        if (this.maps.size() > 1){
            GAME.changeLocation(this.maps.getFirst().getKey());
            this.resetMap();
            for (Pair<Location, Button> p : this.maps) {
                p.getValue().setDisable(false);
            }
        }
    }
}