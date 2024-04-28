package model.location.decorObject;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.character.hero.Hero;
import model.game_pack.Useable;
import model.item.HolyGrenade;

public class HolyGrenadeView extends DecorObjet implements Useable {
    public HolyGrenadeView(int x, int y) {
        super(new HolyGrenade(), x, y);
    }
    @Override
    public String getDescription() {
        return "The great Holy Grenade.";
    }
    @Override
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
    @Override
    public void use(Hero h) {
        this.item.use(h);
        h.getLocation().removeDecorObjet(this);
    }
}

