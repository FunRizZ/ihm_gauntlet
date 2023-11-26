package Location;

import Item.Item;

public class Carcass extends DecorObjet{
	public Carcass(Item i) {
		super(i);
	}
	public Carcass() {
		this(null);
	}
	
    public String getDescription() {
    	return "A carcass, lying in stark stillness, bore the weight of mortality.";
    }
    public String toString() {
    	return "Carcass";
    }
}
