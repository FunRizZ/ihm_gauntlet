package model.character.monster;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.character.WhoFight;
import model.location.decorObject.Wall;

public class Ghost extends WhoFight {
    public final static int DEFAULT_HP = 200;
    public final static int DEFAULT_ARMOR = 10;
    public final static int DEFAULT_DAMAGE = 200;
    public Ghost(int x, int y){super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE,3,1,x,y);}
    @Override
    public String toString() {
        return "Ghost";
    }

    @Override
    public String getDescription() {
        return "A ghost of a human who stays in our World after his death.";
    }
    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/ghost.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(320, 0, 80, 80));
        return view;
    }
}
