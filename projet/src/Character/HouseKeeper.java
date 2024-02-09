package Character;

public class HouseKeeper extends Character{
    public HouseKeeper(int x, int y){super(x, y);}
    @Override
    public String toString() {
        return "HouseKeeper";
    }

    @Override
    public String getDescription() {
        return "The housekeeper looks calm and nice.";
    }
    
}
