package model.Location.decorObject;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall extends DecorObjet {
    public Wall(int x, int y){
        super(x,y);
    }
    @Override
    public String getDescription() {
        return "on giant wall";
    }
    @Override
    public String toString() {
        return "Wall";
    }
    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/wall.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(0, 0, 80, 80));
        return view;
    }
}
