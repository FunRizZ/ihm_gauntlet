package model.Location.decorObject;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item.AttackPotion;
import model.Item.MagicPotion;

public class MagicPotionView extends DecorObjet {
    public MagicPotionView(int x, int y) {
        super(new MagicPotion(), x, y);
    }
    @Override
    public String getDescription() {
        return "A physical potion.";
    }
    @Override
    public String toString() {
        return "Magic_potion";
    }

    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/potion_magic.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(0, 0, 80, 80));
        return view;
    }
}

