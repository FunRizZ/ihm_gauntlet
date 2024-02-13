package apps.mapcreator;

import Game_pack.Game;
import Location.Wall;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class MapCreatorController extends BorderPane{
    private final Game GAME;
    @FXML
    GridPane Map;
    @FXML
    BorderPane Root;
    @FXML
    Tab Tab2;
    public MapCreatorController(Game game) {
        this.GAME = game;
        try {
            // Locate the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(MapCreatorController.class.getResource("MapCreator.fxml"));

            // Since the loaded FXML file is the root of the scene,
            // We must also set the Root as this class
            fxmlLoader.setRoot(this);

            // Actual loading
            fxmlLoader.load();
            Root = this;
            Map = (GridPane) this.getCenter();
            this.generate();
            Tab2 = (Tab) ((TabPane) this.getBottom()).getTabs().get(1);
            System.out.println(Tab2);
            System.out.println(((HBox)Tab2.getContent()).getChildren());
        }
        catch(IOException ioe) {
            System.err.println("MapCreatorControlleur constructor error");
            ioe.printStackTrace();
        }
    }

    /**
     * initialize the gridPane with the Hero's location
     */
    public void generate() {
        ImageView spray;
        for(int x = 0; x < GAME.SIZE_MAP_X; x++){
            for (int y = 0; y < GAME.SIZE_MAP_y; y++){
                Image fondImage = new Image(MapCreatorController.class.getResource("/sprites/floor.png").toExternalForm());
                ImageView fond = new ImageView(fondImage);

                StackPane image = new StackPane(fond);

                if (GAME.HERO.getLocation().BOARD[x][y] != null){       /* definition du spray */
                    spray = GAME.HERO.getLocation().BOARD[x][y].getSpray();
                    image.getChildren().add(spray);
                }

                Map.add(image,x,y);
            }
        }
        Map.setStyle("-fx-background-color : black;");
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
