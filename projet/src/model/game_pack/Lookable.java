package model.game_pack;

import javafx.scene.image.ImageView;

public abstract class Lookable {
    private int x;
    private int y;
    public Lookable(int x, int y){
        this.x = x;
        this.y = y;
    }
    public abstract void look();

    public int getPosX() {
        return x;
    }
    public int getPosY() {
        return y;
    }
    public void setPosX(int x){this.x = x;}
    public void setPosY(int y){this.y = y;}
    public double getDistance(Lookable other){
        return Math.sqrt(Math.pow((this.x - other.x),2) + Math.pow((this.y - other.y),2));
    }
    /**
     * @return the path of the spray
     */
    public abstract ImageView getSpray();
}
