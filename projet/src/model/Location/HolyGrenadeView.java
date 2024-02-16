package model.Location;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item.HolyGrenade;
import model.Item.Item;
import model.Item.Potion;
import model.Item.Treasure;

public class HolyGrenadeView extends DecorObjet{
    public HolyGrenadeView(int x, int y) {
        super((Item)new HolyGrenade(), x, y);
    }

    public String getDescription() {
        return "The great Holy Grenade.";
    }
    public String toString() {
        return "HolyGrenade";
    }

    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/smart_bomb.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(0, 0, 80, 80));
        return view;
    }
}

