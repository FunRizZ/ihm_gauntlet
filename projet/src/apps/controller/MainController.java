package apps.controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
    public static Scene scene;
    public static Stage stage;
    
    public void changeScene(Parent gameMenu) {
        stage=getStage();
        // Scene dimensions
        double width = 1600, height = 900;
        scene = new Scene(gameMenu, width,height);
        stage.setScene(scene);
        setScene(scene);
    }

    public void setScene(Scene scene) {
        MainController.scene = scene;
    }

    public void setStage(Stage stage) {
        MainController.stage = stage;
    }

    public static Scene getScene() {
        return scene;
    }
    public static Stage getStage() {
        return stage;
    }
}
