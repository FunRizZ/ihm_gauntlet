package apps.controller;

import apps.game.GameMenuScene;
import javafx.fxml.FXML;


public class CreditsController{

    /**
     * Changes the actual scene to the Main Menu scene
     */
    @FXML
    public void goMenu() {
        GameMenuScene GameMenu = new GameMenuScene();
        GameMenu.changeScene(GameMenu.GAME_MENU, GameMenu.SCENE_TITLE);
    }
}