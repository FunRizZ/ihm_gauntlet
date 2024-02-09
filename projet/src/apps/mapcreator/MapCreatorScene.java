package apps.mapcreator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * A first example of Scene
 **/
public class MapCreatorScene extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception {  
	
				final BorderPane MapCreator = new MapCreatorMenuController();
	
				// Scene dimensions
				double width = 1600, height = 900;

				// Scene = container for all content
				Scene scene = new Scene(MapCreator, width, height);
	
				primaryStage.setScene(scene);
				primaryStage.setTitle("Hello World!");
				primaryStage.show ();
    } 

 
    public static void main (String args []) {
				launch (args);
    } 
}
