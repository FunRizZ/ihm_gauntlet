package apps.mapcreator;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MapCreatorMenuController extends BorderPane {

    public MapCreatorMenuController() {
				try {
						// Locate the FXML file
						FXMLLoader fxmlLoader = new FXMLLoader(MapCreatorMenuController.class.getResource("MapCreatorMenu.fxml"));

						// Since the loaded FXML file is the root of the scene,
						// We must also set the Root as this class
						fxmlLoader.setRoot(this);

						// Actual loading
						fxmlLoader.load();
				}
				catch(IOException ioe) {
						System.err.println("MapCreator constructor error");
						ioe.printStackTrace();
				}
    }
}
