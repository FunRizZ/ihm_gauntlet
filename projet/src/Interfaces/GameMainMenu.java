package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class GameMainMenu extends Application {
    @Override
    public void start(Stage myStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameMainMenu.fxml"));
        myStage.setTitle("Test Main Menu");
        myStage.setScene(new Scene(root, 1600,900));
        myStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
