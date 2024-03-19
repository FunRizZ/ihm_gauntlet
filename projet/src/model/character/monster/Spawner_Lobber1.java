package model.character.monster;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.location.decorObject.Wall;

public class Spawner_Lobber1 extends Spawner {
    public Spawner_Lobber1(int x, int y) {
        super(new Lobber(-1,-1,1).getHp()*2, new Lobber(-1,-1,1).getArmor()*2, new Lobber(-1,-1,1), x, y,1);
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
        view.setViewport(new Rectangle2D(0, 0, 80, 80));
        return view;
    }
}
