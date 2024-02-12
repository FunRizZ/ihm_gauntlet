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
    public void initialize() {
        for(int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                System.out.println(x +" , "+y);
                Button button = new Button(x +" , "+y);
                Map.add(button,x,y);
            }
        }
    }
}
