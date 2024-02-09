package Interfaces;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Node;


public class GameMainMenu{
    private Parent root;
    private Scene scene;
    private Stage stage;


    @FXML
    public void handleQuit(ActionEvent event) {
        System.out.println("You leave the game. Goodbye!");
        Platform.exit();
    }

    @FXML
    public void changeScene(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("MapCreatorMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root, 1000,600);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
