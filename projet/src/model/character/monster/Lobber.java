package model.character.monster;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.character.WhoFight;
import model.location.decorObject.Wall;

public class Lobber extends WhoFight {
    public final static int DEFAULT_HP = 100;
    public final static int DEFAULT_ARMOR = 10;
    public final static int DEFAULT_DAMAGE = 200;
    public Lobber(int x, int y){super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE,3,1,x,y);}
    @Override
    public String toString() {
        return "Lobber";
    }

    @Override
    public String getDescription() {
        return "A lobber.";
    }
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/lobber.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(320, 0, 80, 80));
        return view;
    }
}
