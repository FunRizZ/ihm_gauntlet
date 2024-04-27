package apps.game.pause;

import apps.controller.GameController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PauseScene{
    public final PauseLoad MENU;
    public static Stage pauseStage;

    public PauseScene() {
        MENU = new PauseLoad();
        MENU.init();
    }

    public void load() {
        if (pauseStage != null && pauseStage.getScene() != null) {
            pauseStage.getScene().setRoot(MENU);
            pauseStage.setTitle("Pause");

            pauseStage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
                if (event.getCode() == KeyCode.ESCAPE) {
                    GameController.isPaused = false;
                    pauseStage.close();
                }
            });

            pauseStage.show();
        } else {
            loadNewScene();
        }
    }

    public void loadNewScene() {
        Scene pauseScene = new Scene(MENU, 300, 300);
        pauseStage = new Stage();
        pauseStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        pauseStage.setScene(pauseScene);
        pauseStage.setTitle("Pause");

        pauseScene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                GameController.isPaused = false;
                pauseStage.close();
            }
        });

        pauseStage.show();
    }
}