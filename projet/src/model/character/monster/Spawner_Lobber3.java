package model.character.monster;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.location.decorObject.Wall;

public class Spawner_Lobber3 extends Spawner {
    public Spawner_Lobber3(int x, int y) {
        super(new Lobber(-1,-1,3).getHp()*2, new Lobber(-1,-1,3).getArmor()*2, new Lobber(-1,-1,3), x, y,3);
    }

    @Override
    public String getDescription() {
        return "Spawner Lobber 1";
    }
    @Override
    public String toString() {
        return "Spawner_Lobber";
    }
    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/spawner_grunt.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(160, 0, 80, 80));
        return view;
    }
}
