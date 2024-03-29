package model.location.decorObject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spawn extends DecorObjet {
    public static int i = 0;
    public Spawn(int x, int y){
        super(x,y);
    }
    public String getDescription() {
        return "Spawn of a map";
    }
    public String toString() {
        return "Spawn";
    }

    @Override
    public ImageView getSpray(){
        i++;
        Image spray = (new Image(Wall.class.getResource("/sprites/h"+i+".png").toExternalForm()));
        i = i%4;
        return new ImageView(spray);
    }
}
