package model.game_pack;

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
    public void setPosX(int x){this.x = x;}
    public void setPosY(int y){this.Y = y;}
    /**
     * @return the path of the spray
     */
    public abstract ImageView getSpray();
}
