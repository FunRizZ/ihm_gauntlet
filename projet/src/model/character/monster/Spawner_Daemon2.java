package model.character.monster;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.location.decorObject.Wall;

public class Spawner_Daemon2 extends Spawner {
    public Spawner_Daemon2(int x, int y) {
        super(new Daemon(-1,-1,2).getHp()*2, new Daemon(-1,-1,2).getArmor()*2, new Daemon(-1,-1,2), x, y,2);
    }

    @Override
    public String getDescription() {
        return "Spawner Daemon 2";
    }
    @Override
    public String toString() {
        return "Spawner_Daemon";
    }
    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/spawner_grunt.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(80, 0, 80, 80));
        return view;
    }
}
