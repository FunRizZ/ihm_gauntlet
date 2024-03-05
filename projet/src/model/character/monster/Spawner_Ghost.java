package model.character.monster;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.location.decorObject.Wall;

public class Spawner_Ghost extends Spawner {

    public Spawner_Ghost( int x, int y) {
        super(new Ghost(-1,-1).getHp()*2, new Ghost(-1,-1).getArmor()*2, new Ghost(-1,-1), 4, x, y);
    }

    @Override
    public String getDescription() {
        return "Spawner of ghost";
    }
    @Override
    public String toString() {
        return "Spawner_Ghost";
    }
    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/spawner_ghost.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(80, 0, 80, 80));
        return view;
    }
}
