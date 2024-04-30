package apps.controller;

import apps.game.GameScene;
import apps.mainMenu.MainMenuScene;
import apps.setting.JsonSetting;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.character.hero.*;
import model.game_pack.Game;

/**
 * Class Controller for Select Hero
 */
public class SelectHeroController extends BorderPane {
    public final Game GAME;
    @FXML
    HBox selection;
    @FXML
    HBox buttons;
    @FXML
    StackPane Elf;
    @FXML
    Button ElfButton;
    @FXML
    StackPane Warrior;
    @FXML
    Button WarriorButton;
    @FXML
    StackPane Valkyrie;
    @FXML
    Button ValkyrieButton;
    @FXML
    StackPane Wizard;
    @FXML
    Button WizardButton;
    @FXML
    Button proceed;
    @FXML
    Button quit;

    public SelectHeroController(){
        GAME = Game.GAME;
    }
    @FXML
    public void initialize(){
        //buttons.prefWidthProperty().bind(this.prefWidthProperty());

        Elf.getChildren().add(new Elf(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
        Elf.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> ElfHandle());
        Warrior.getChildren().add(new Warrior(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
        Warrior.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> WarriorHandle());
        Valkyrie.getChildren().add(new Valkyrie(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
        Valkyrie.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> ValkyrieHandle());
        Wizard.getChildren().add(new Wizard(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
        Wizard.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> WizardHandle());
    }
    @FXML
    public void ElfHandle(){
        GAME.addHero(new Elf(GAME.getMainHero().getLocation(),
                JsonSetting.getSetting(GAME.NB_HERO -1),
                GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosX(),
                GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosY()));
        ElfButton.setDisable(true);
    }
    @FXML
    public void WarriorHandle(){
        GAME.addHero(new Warrior(GAME.getMainHero().getLocation(),
                JsonSetting.getSetting(GAME.NB_HERO -1),
                GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosX(),
                GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosY()));
        WarriorButton.setDisable(true);
    }
    @FXML
    public void ValkyrieHandle(){
        GAME.addHero(new Valkyrie(GAME.getMainHero().getLocation(),
                JsonSetting.getSetting(GAME.NB_HERO -1),
                GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosX(),
                GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosY()));
        ValkyrieButton.setDisable(true);
    }
    @FXML
    public void WizardHandle(){
        GAME.addHero(new Wizard(GAME.getMainHero().getLocation(),
                JsonSetting.getSetting(GAME.NB_HERO -1),
                GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosX(),
                GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosY()));
        WizardButton.setDisable(true);
    }

    /**
     * Change the actual scene to the Main Menu scene
     */
    @FXML
    public void changeGameMenu() {
        MainMenuScene gameMenu = new MainMenuScene();
        gameMenu.load();
    }
    /**
     * Change the actual scene to the Main Menu scene
     */
    @FXML
    public void handleProceed() {
        System.out.println(GAME.NB_HERO);
        for (Hero h : GAME.HEROS){
            System.out.println(h.getClass().getSimpleName());
        }

        GameScene game = new GameScene();
        boolean load = Game.GAME.Load("./save/locations/GARDEN.json");
        System.out.println(load);
        game.load();
    }
}
