package Location;


import Item.Item;
import Item.key;

public class Cupboard extends DecorObjet{
	public Cupboard() {
		super((Item)new key());
	}

    public String getDescription() {
    	return "A dusty cupboard, nestled in the corner, bores the weight of time.";
    }
    public String toString() {
    	return "Cupboard";
    }
}
