package model.Character;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Location.Wall;

public class Ghost extends Character {
    public Ghost(int x, int y){super(x,y);}
    @Override
    public String toString() {
        return "Ghost";
    }

    @Override
    public String getDescription() {
        return "A ghost of a human who stays in our World after his death.";
    }
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/ghost.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(320, 0, 80, 80));
        return view;
    }
}
