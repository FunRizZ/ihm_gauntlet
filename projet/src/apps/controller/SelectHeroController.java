package apps.controller;

import apps.game.GameMenuScene;
import apps.setting.JsonSetting;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.character.hero.*;
import model.game_pack.Game;

public class SelectHeroController extends BorderPane {
    public final Game GAME;
    @FXML
    HBox selection;
    @FXML
    HBox buttons;
    @FXML
    StackPane Elf;
    @FXML
    StackPane Warrior;
    @FXML
    StackPane Valkyrie;
    @FXML
    StackPane Wizard;

    public SelectHeroController(){
        GAME = Game.GAME;
    }
    @FXML
    public void initialize(){
        //buttons.prefWidthProperty().bind(this.prefWidthProperty());

        Elf.getChildren().add(new Elf(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
        Elf.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> GAME.addHero(new Elf(GAME.getMainHero().getLocation(),
                                                                                    JsonSetting.getSetting(GAME.NB_HERO -1),
                                                                                    GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosX(),
                                                                                    GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosY())));
        Warrior.getChildren().add(new Warrior(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
        Warrior.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> GAME.addHero(new Warrior(GAME.getMainHero().getLocation(),
                                                                                        JsonSetting.getSetting(GAME.NB_HERO -1),
                                                                                        GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosX(),
                                                                                        GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosY())));
        Valkyrie.getChildren().add(new Valkyrie(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
        Valkyrie.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> GAME.addHero(new Valkyrie(GAME.getMainHero().getLocation(),
                                                                                        JsonSetting.getSetting(GAME.NB_HERO -1),
                                                                                        GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosX(),
                                                                                        GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosY())));
        Wizard.getChildren().add(new Wizard(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
        Wizard.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> GAME.addHero(new Wizard(GAME.getMainHero().getLocation(),
                                                                                        JsonSetting.getSetting(GAME.NB_HERO -1),
                                                                                        GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosX(),
                                                                                        GAME.getMainHero().getLocation().SPAWNS.get(GAME.NB_HERO -1).getPosY())));
    }
    /**
     * Change the actual scene to the Main Menu scene
     */
    @FXML
    public void changeGameMenu() {
        GameMenuScene gameMenu = new GameMenuScene();
        gameMenu.changeScene(gameMenu.GAME_MENU, gameMenu.SCENE_TITLE);
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
    }
}
