package model.location.decorObject;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Door extends DecorObjet{
    public static int orientation = 0;
    public Door(int x, int y) {
        super(x, y);
    }
    public Door(int x, int y, int new_orientation) {
        super(x, y);
        orientation = new_orientation;
    }
    @Override
    public String toString() {
        return "Door";
    }
    @Override
    public String getDescription() {
        return "The locked door, its sturdy frame imposing and mysterious, guards its secrets behind an impenetrable barrier.";
    }
    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/door.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(orientation*80, 0, 80, 80));
        orientation++;
        orientation = orientation%15;
        return view;
    }
}
