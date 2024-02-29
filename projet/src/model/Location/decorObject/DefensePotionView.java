package model.Location.decorObject;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item.AttackPotion;
import model.Item.DefensePotion;

public class DefensePotionView extends DecorObjet {
    public DefensePotionView(int x, int y) {
        super(new DefensePotion(), x, y);
    }
    @Override
    public String getDescription() {
        return "A defense potion.";
    }
    @Override
    public String toString() {
        return "Defense_potion";
    }

    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/potion_defense.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(0, 0, 80, 80));
        return view;
    }
}

