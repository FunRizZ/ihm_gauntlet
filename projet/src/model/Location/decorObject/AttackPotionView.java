package model.Location.decorObject;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item.AttackPotion;

public class AttackPotionView extends DecorObjet {
    public AttackPotionView(int x, int y) {
        super(new AttackPotion(), x, y);
    }
    @Override
    public String getDescription() {
        return "A physical potion.";
    }
    @Override
    public String toString() {
        return "Attack_potion";
    }

    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/potion_physical.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(0, 0, 80, 80));
        return view;
    }
}

