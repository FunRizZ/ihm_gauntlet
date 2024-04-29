package model.character.hero;


import apps.setting.SettingPersonnage;
import model.location.Location;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Valkyrie extends Hero {
    public final static int DEFAULT_RANGE = 3;

    public Valkyrie(Location location, SettingPersonnage setting, int x, int y) {
        super(location, setting, x, y,700,150,200, DEFAULT_RANGE);
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
        Image spray = (new Image(Hero.class.getResource("/sprites/valkyrie.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        switch (this.direction){
            case TOP -> view.setViewport(new Rectangle2D(0, 0, 80, 80));
            case LEFT -> view.setViewport(new Rectangle2D(5*80, 80, 80, 80));
            case RIGHT -> view.setViewport(new Rectangle2D(80, 80, 80, 80));
            default -> view.setViewport(new Rectangle2D(320, 0, 80, 80));
        }
        return view;
    }
    @Override
    public void changeAttackSpeed(){
        if (attack_speed > 0){
            attack_speed -= 25;
            System.out.println("HERO attack speed : " + attack_speed);
        }
    }
}