package apps.game;

import apps.controller.SettingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SelectHeroLoad extends BorderPane {
    private final FXMLLoader fxmlLoader;

    public SelectHeroLoad() {
        fxmlLoader = new FXMLLoader(SelectHeroLoad.class.getResource("SelectHero.fxml"), SettingController.language);
    }

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
