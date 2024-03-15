package apps.controller;

import apps.mainMenu.MainMenuScene;
import javafx.fxml.FXML;

/**
 * Class Controller for the Credits
 */
public class CreditsController{

    /**
     * Changes the actual scene to the Main Menu scene
     */
    @FXML
    public void goMenu() {
        MainMenuScene GameMenu = new MainMenuScene();
        GameMenu.changeScene(GameMenu.GAME_MENU, GameMenu.SCENE_TITLE);
    }
}