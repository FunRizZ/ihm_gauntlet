package model.Item;

public class Basilic extends Weapon{
    public final static int DEFAULT_DAMAGE = 300;
    public Basilic() {
    	super(DEFAULT_DAMAGE);
    }
    @Override
    public String toString() {
    	return "Basilic";
    }
}
