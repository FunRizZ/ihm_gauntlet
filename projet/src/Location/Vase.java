package Location;

import Item.Item;
import Item.BeastlyShield;

public class Vase extends DecorObjet{
	public Vase() {
		super((Item)new BeastlyShield());
	}


    public String getDescription() {
    	return "An old vase with a magnificent design which represents all the wealth of the castle";
    }
    public String toString() {
    	return "Vase";
    }
}
