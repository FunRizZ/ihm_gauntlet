package model.location.decorObject;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.item.Item;
import model.item.HealPotion;

public class HealPotionView extends DecorObjet {
    public HealPotionView(int x, int y) {
        super((Item)new HealPotion(), x, y);
    }

    public String getDescription() {
        return "A heal potion.";
    }
    public String toString() {
        return "Potion";
    }

    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/potion_life.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(0, 0, 80, 80));
        return view;
    }
}

