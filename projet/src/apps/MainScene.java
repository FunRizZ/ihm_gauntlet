package apps;

import apps.setting.JsonSetting;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class of the Main Scene
 */
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

    /**
     * Set the dimensions of the windows' main Scene
     */
    public MainScene(){
        this.width = JsonSetting.getSettingsScene().getWidth();
        this.height = JsonSetting.getSettingsScene().getHeight();
    }

    /**
     * Change Scene
     * @param gameMenu Actual scene
     * @param sceneTitle Title of the windows
     */
    public void changeScene(Parent gameMenu, String sceneTitle) {
        this.sceneTitle = sceneTitle;

        scene = new Scene(gameMenu, this.width, this.height);

        stage.setTitle(this.sceneTitle);
        stage.setScene(scene);
        setScene(scene);
    }

    /**
     * Set the new scene
     * @param newscene
     */
    public void setScene(Scene newscene) {
        scene = newscene;
    }

    /**
     * Set the new stage
     * @param newstage
     */
    public void setStage(Stage newstage) {
        stage = newstage;
    }

    /**
     * Get the actual scene
     * @return scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Get the actual scene
     * @return stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * load in MainController the scene
     */
    public abstract void load();
}
