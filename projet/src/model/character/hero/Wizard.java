package model.character.hero;


import apps.setting.SettingPersonnage;
import model.location.Location;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wizard extends Hero {
    public final static int DEFAULT_RANGE = 6;


    public Wizard(Location location, SettingPersonnage setting, int x, int y) {
        super(location, setting, x, y,500,50,600, DEFAULT_RANGE);
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
        Image spray = (new Image(Hero.class.getResource("/sprites/wizard.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        switch (this.direction){
            case TOP -> view.setViewport(new Rectangle2D(0, 80, 80, 80));
            case LEFT -> view.setViewport(new Rectangle2D(5*80, 80, 80, 80));
            case RIGHT -> view.setViewport(new Rectangle2D(2*80, 80, 80, 80));
            default -> view.setViewport(new Rectangle2D(320, 0, 80, 80));
        }
        return view;
    }
    @Override
    public void changeAttackSpeed(){
        if (attack_speed > 0){
            attack_speed -= 10;
        }
    }
}