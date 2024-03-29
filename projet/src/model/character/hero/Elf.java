package model.character.hero;


import apps.setting.SettingPersonnage;
import model.location.Location;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Elf extends Hero {

    //TODO Ajouter les stats de vitesse et de range d'attaque
    public Elf(Location location, SettingPersonnage setting, int x, int y) {
        super(location, setting, x, y,500,50,200,100);
    }

    @Override
    public String getDescription() {
        return "The Hero is in "+ getLocation().NAME + ". He is in travel to found the long-lost treasure hidden in this castel.";
    }
    public String toString() {
        return "HERO";
    }

    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Hero.class.getResource("/sprites/elf.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(320, 0, 80, 80));
        return view;
    }
}
