package apps.mapcreator;

import Game_pack.Game;
import Game_pack.Lookable;
import Location.Wall;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    StackPane Img21;
    public MapCreatorController() {
        this.GAME = MapCreator.GAME;
        this.object_select = -1;
    }
    @FXML
    public void initialize(){
        this.generate();
        MapTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Img21.getChildren().add((new Wall(0,0)).getSpray());
        Img21.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> this.object_select = 1);
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

        fond.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> addLookable(GridPane.getColumnIndex(image),GridPane.getRowIndex(image)));
        if (GAME.HERO.getLocation().BOARD[x][y] != null){       /* definition du spray */
            ImageView spray = GAME.HERO.getLocation().BOARD[x][y].getSpray();

            image.getChildren().add(spray);
        }
        Map.add(image,x,y);
    }
    public Lookable getLookable(int x, int y){
        System.out.println(this.object_select+" , "+x +" , "+y);
        switch (this.object_select){
            case 1 -> {
                return new Wall(x,y);
            }
            default -> {return null;}
        }
    }
    public void addLookable(int x, int y){
        Lookable l = getLookable(x,y);
        if (l != null){ GAME.HERO.getLocation().addLookable(l);}

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
