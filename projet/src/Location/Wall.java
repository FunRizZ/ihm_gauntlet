package Location;

public class Wall extends DecorObjet{
    public Wall(int x, int y){
        super(x,y);
    }
    public String getDescription() {
        return "on giant wall";
    }
    public String toString() {
        return "Wall";
    }
}
