package apps.game;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

/**
 * Loading Select Hero
 */
public class SelectHeroLoad extends BorderPane {
    private final FXMLLoader fxmlLoader;

    /**
     * Load the Select Hero with fxmlLoader
     */
    public SelectHeroLoad() {
        fxmlLoader = new FXMLLoader(SelectHeroLoad.class.getResource("SelectHero.fxml"), SettingController.language);
    }

    /**
     * Initialize the scene
     */
    public void init() {
        try {
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch(Exception ioe) {
            System.err.println("SelectHeroLoad constructor error");
            ioe.printStackTrace();
        }
    }
}
