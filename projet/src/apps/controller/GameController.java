package apps.controller;

import apps.MainScene;
import apps.game.pause.PauseScene;
import apps.game.pause.soundSetting.SoundManager;
import apps.setting.JsonSetting;
import apps.setting.SettingPersonnage;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.WindowEvent;
import model.character.Direction;
import model.character.WhoFight;
import model.character.hero.Hero;
import model.game_pack.Game;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import java.util.HashSet;
import java.awt.Point;

public class GameController extends Pane {
    public final Game GAME;
    public final SettingPersonnage[] SETTINGS;
    public final long timeSt;
    private Node[][] gridPaneArray = null;
    public static ScheduledExecutorService service;
    @FXML
    GridPane map;
    @FXML
    Label difficulty;
    @FXML
    Label nameLocation;
    @FXML
    Label time;
    @FXML
    Label joueur1hp;
    @FXML
    Label joueur1nbKey;
    @FXML
    Label joueur2hp;
    @FXML
    Label joueur2nbKey;
    @FXML
    Label joueur3hp;
    @FXML
    Label joueur3nbKey;
    @FXML
    Label joueur4hp;
    @FXML
    Label joueur4nbKey;

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
                Hero hero = GAME.HEROS.get(i);
                Set<Point> cells = new HashSet<>();
                cells.add(new Point(hero.getPosX(), hero.getPosY()));
                switch (setting_personnage.getKeyString(key)) {
                    case "UP": {
                        hero.direction = Direction.TOP;
                        break;
                    }
                    case "DOWN": {
                        hero.direction = Direction.BOTTOM;
                        break;
                    }
                    case "LEFT": {
                        hero.direction = Direction.LEFT;
                        break;
                    }
                    case "RIGHT": {
                        hero.direction = Direction.RIGHT;
                        break;
                    }
                }
                if(hero.getLocation().move(hero)){
                    cells.add(new Point(hero.getPosX(), hero.getPosY()));
                    cells.forEach(cell -> {
                        this.resetCell(cell.x, cell.y);
                    });
                } else {
                    System.out.println("impossible move");
                }
            }
        }
    }
    public GameController(){
        this.GAME = Game.GAME;
        this.SETTINGS = JsonSetting.getSetting();
        this.timeSt = System.nanoTime();
        service = Executors.newSingleThreadScheduledExecutor();
        SoundManager soundManager = new SoundManager();
        soundManager.initialize();
        SoundManager.play();
        service.scheduleAtFixedRate(() -> {
            // Action à effectuer toutes les demi-secondes
            Platform.runLater(() -> {
                this.resetInterface();
                Set<Point> cells = new HashSet<>();
                GAME.getMainHero().getLocation().getCharacters().forEach(character -> {
                    if (character instanceof WhoFight && !(character instanceof Hero)){
                        cells.add(new Point(character.getPosX(), character.getPosY()));
                    }
                });
                if (!GAME.attackHero()){
                    System.out.println("game lose");
                    this.resetInterface();
                    service.shutdown();
                }
                GAME.getMainHero().getLocation().getCharacters().forEach(character -> {
                    if (character instanceof WhoFight && !(character instanceof Hero)){
                        cells.add(new Point(character.getPosX(), character.getPosY()));
                    }
                });
                cells.forEach(cell -> {
                    this.resetCell(cell.x, cell.y);
                });
                //System.out.println("Action exécutée toutes les demi-secondes");
            });
        }, 0, 500, TimeUnit.MILLISECONDS);
        MainScene.stage.setOnCloseRequest((WindowEvent event) -> {
            // Arrêter le ScheduledExecutorService lorsque la fenêtre se ferme
            if (!service.isShutdown()) {
                service.shutdown();
            }
        });
    }

    @FXML
    public void initialize(){
        nameLocation.textProperty().bind(new SimpleStringProperty(GAME.getMainHero().getLocation().NAME.name()));
        this.resetInterface();
        this.initializeGridPaneArray();
        this.resetMap();
    }

    private void initializeGridPaneArray()
    {
        
       this.gridPaneArray = new Node[GAME.SIZE_MAP_X][GAME.SIZE_MAP_y];
       for(Node node : map.getChildren())
       {
          this.gridPaneArray[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = node;
       }
    }

    private void changeNode(Node node, int x, int y)
    {
        gridPaneArray[x][y]=node;
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
        changeNode(image, x, y);
    }
    
    public void resetMap(){
        map.getChildren().clear();
        for (int x = 0; x < GAME.getMainHero().getLocation().SIZE_X; x++){
            for (int y = 0; y < GAME.getMainHero().getLocation().SIZE_Y; y++){
                reset(x,y);
            }
        }
    }
    
    public void resetCell(int x, int y) {
        Node n = this.gridPaneArray[x][y];
        map.getChildren().remove(n);
        reset(x, y);
    }

    public void resetInterface(){
        time.setText(String.valueOf((System.nanoTime() - timeSt) / 1000000000));

        joueur1hp.setText(String.valueOf(GAME.HEROS.get(0).getHp()));
        joueur1nbKey.setText(String.valueOf(GAME.HEROS.get(0).getNbKeys()));
        try {
            joueur2hp.setText(String.valueOf(GAME.HEROS.get(1).getHp()));
            joueur2nbKey.setText(String.valueOf(GAME.HEROS.get(1).getNbKeys()));
        }catch (IndexOutOfBoundsException e){
            joueur2hp.setText("xxx");
            joueur2nbKey.setText("xxx");
        }
        try {
            joueur3hp.setText(String.valueOf(GAME.HEROS.get(2).getHp()));
            joueur3nbKey.setText(String.valueOf(GAME.HEROS.get(2).getNbKeys()));
        }catch (IndexOutOfBoundsException e){
            joueur3hp.setText("xxx");
            joueur3nbKey.setText("xxx");
        }
        try {
            joueur4hp.setText(String.valueOf(GAME.HEROS.get(3).getHp()));
            joueur4nbKey.setText(String.valueOf(GAME.HEROS.get(3).getNbKeys()));
        }catch (IndexOutOfBoundsException e){
            joueur4hp.setText("xxx");
            joueur4nbKey.setText("xxx");
        }
    }
}
