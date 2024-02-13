package Game_pack;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Lookable {
    private int x;
    private int Y;
    public Lookable(int x, int y){
        this.x = x;
        this.Y = y;
    }
    public abstract void look();

    public int getPosX() {
        return x;
    }
    public int getPosY() {
        return Y;
    }

    /**
     * @return the path of the spray
     */
    public abstract ImageView getSpray();
}
