package apps.mapcreator;

import model.Game_pack.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A first example of Scene
 **/
public class MapCreatorScene extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception {
        MapCreator mapCreator = new MapCreator(Game.GAME);// Scene dimensions


		// Scene dimensions
		double width = 1600, height = 900;

        // Scene = container for all content
        Scene scene = new Scene(mapCreator, width, height);
	
		primaryStage.setScene(scene);
		primaryStage.setTitle("Gauntlet Map Creator");
		primaryStage.show ();
//		MainController mainController = new MainController();
//        mainController.setScene(scene);
//		mainController.setStage(primaryStage);
    } 

 
    public static void main (String args []) {
				launch (args);
    } 
}
