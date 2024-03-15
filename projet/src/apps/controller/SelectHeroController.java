package apps.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.character.hero.Elf;
import model.character.hero.Valkyrie;
import model.character.hero.Warrior;
import model.character.hero.Wizard;
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
        Warrior.getChildren().add(new Warrior(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
        Valkyrie.getChildren().add(new Valkyrie(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
        Wizard.getChildren().add(new Wizard(GAME.getMainHero().getLocation(), null, 0, 1).getSpray());
    }
}
