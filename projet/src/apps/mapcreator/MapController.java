package apps.mapcreator;

import Game_pack.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MapController {

    @FXML
    GridPane Map;
    public MapController(){}
    @FXML
    public void generate(Game game) {
        for(int x = 0; x < game.SIZE_MAP_X; x++){
            for (int y = 0; y < game.SIZE_MAP_y; y++){
                System.out.println(x +" , "+y);
                Button button = new Button(x +" , "+y);
                Map.add(button,x,y);
            }
        }
    }
}
