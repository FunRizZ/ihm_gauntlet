package apps.mapcreator;

import model.Game_pack.Game;
import model.Game_pack.Lookable;
import model.Item.Potion;
import model.Location.HolyGrenadeView;
import model.Location.PotionView;
import model.Location.TreasureView;
import model.Location.Wall;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    Tab Tab12;

    @FXML
    Button Delete;
    @FXML
    StackPane Img31;
    @FXML
    StackPane Img41;
    @FXML
    StackPane Img61;
    @FXML
    StackPane Img71;
    @FXML
    StackPane Img81;
    public MapCreatorController() {
        this.GAME = MapCreator.GAME;
        this.object_select = -1;
    }
    @FXML
    public void initialize(){
        this.generate();
        MapTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Img31.getChildren().add((new PotionView(-1,-1)).getSpray());
        Img31.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 31);
        Img41.getChildren().add((new HolyGrenadeView(-1,-1)).getSpray());
        Img41.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 41);
        Img61.getChildren().add((new Wall(-1,-1)).getSpray());
        Img61.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> this.object_select = 61);
        //TODO : faire Exit + key
//        Img71.getChildren().add((new PotionView(-1,-1)).getSpray());
//        Img71.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 71);
        Img81.getChildren().add((new TreasureView(-1,-1)).getSpray());
        Img81.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.object_select = 81);

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

            image.getChildren().add(spray);
        }
        Map.add(image,x,y);
    }
    public Lookable getLookable(int x, int y){
        switch (this.object_select){
            case 31 -> {
                return new PotionView(x,y);
            }
            case 41 -> {
                return new HolyGrenadeView(x,y);
            }
            case 61 -> {
                return new Wall(x,y);
            }
            case 81 -> {
                return new TreasureView(x,y);
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

    /**
     * @param node the node were the dezoom is applied
     * @param val value of the dezoom
     */
    @FXML
    public void dezoom(Node node, double val){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.1),node);
        scaleTransition.setToX(1-val); // échelle horizontale
        scaleTransition.setToY(1-val); // échelle verticale
        scaleTransition.play();
    }

}
