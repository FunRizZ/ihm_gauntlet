package apps.game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import projet.src.apps.mapcreator.MapCreatorMenuController;

import javafx.scene.Node;



public class GameMenuController{
    private Scene scene;
    private Stage stage;


    @FXML
    public void handleQuit(ActionEvent event) {
        System.out.println("You leave the game. Goodbye!");
        Platform.exit();
    }

    @FXML
    public void changeScene(ActionEvent event) {
        final BorderPane MapCreator = new MapCreatorMenuController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // Scene dimensions
		double width = 1600, height = 900;
        scene = new Scene(MapCreator, width,height);
        stage.setScene(scene);
        stage.show();
    }
}