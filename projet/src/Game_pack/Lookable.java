package Game_pack;

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
}
