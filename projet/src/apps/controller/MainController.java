package apps.controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
    private static Scene scene;
    private static Stage stage;
    
    public void changeScene(Parent gameMenu) {
        stage=getStage();
        // Scene dimensions
        double width = 1600, height = 900;
        scene = new Scene(gameMenu, width,height);
        stage.setScene(scene);
        stage.show();
        setscene(scene, stage);
    }

    public void setscene(Scene scene, Stage stage) {
        MainController.scene = scene;
        MainController.stage = stage;
    }

    public static Scene getScene() {
        return scene;
    }
    public static Stage getStage() {
        return stage;
    }
}