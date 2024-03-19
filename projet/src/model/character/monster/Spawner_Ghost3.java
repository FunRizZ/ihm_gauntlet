package model.character.monster;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.location.decorObject.Wall;

public class Spawner_Ghost3 extends Spawner {

    public Spawner_Ghost3(int x, int y, int level) {
        super(new Ghost(-1,-1,3).getHp()*2, new Ghost(-1,-1,3).getArmor()*2, new Ghost(-1,-1,3), x, y,level);
    }

    @Override
    public String getDescription() {
        return "Spawner Ghost 3";
    }
    @Override
    public String toString() {
        return "Spawner_Ghost";
    }
    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/spawner_ghost.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(160, 0, 80, 80));
        return view;
    }
}
