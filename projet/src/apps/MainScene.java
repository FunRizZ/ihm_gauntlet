package apps;

import apps.setting.Json_control_setting_personnage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class MainScene {
    public static Scene scene;
    public static Stage stage;
    public String sceneTitle;
    /**
     * scene dimension : width
     */
    public double width;
    /**
     * scene dimension : height
     */
    public double height;
    public MainScene(){
        Json_control_setting_personnage setting = new Json_control_setting_personnage();
        this.width = setting.getSettingsScene().getWidth();
        this.height = setting.getSettingsScene().getHeight();
    }
    public void changeScene(Parent gameMenu, String sceneTitle) {
        this.sceneTitle = sceneTitle;

        scene = new Scene(gameMenu, this.width, this.height);

        stage.setScene(scene);
        setScene(scene);
    }

    public void setScene(Scene scene) { this.scene = scene; }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }
    public Stage getStage() {
        return stage;
    }

    /**
     * load in MainController the scene
     */
    public abstract void load();
}
