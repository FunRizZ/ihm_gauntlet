package model.location.decorObject;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.character.hero.Hero;
import model.game_pack.Useable;
import model.item.PoisonPotion;

public class PoisonPotionView extends DecorObjet implements Useable {
    public PoisonPotionView(int x, int y) {
        super(new PoisonPotion(), x, y);
    }
    @Override
    public String getDescription() {
        return "A poison potion.";
    }
    @Override
    public String toString() {
        return "Poison";
    }

    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/potion_life.png").toExternalForm()));
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

