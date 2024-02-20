package apps;

import apps.setting.JsonSetting;
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
        this.width = JsonSetting.getSettingsScene().getWidth();
        this.height = JsonSetting.getSettingsScene().getHeight();
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
