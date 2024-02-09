package Location;

import Item.Item;

public class Carcass extends DecorObjet{
	public Carcass(Item i, int x, int y) {
		super(i, x, y);
	}
	public Carcass(int x, int y) {
		this(null, x, y);
	}
	
    public String getDescription() {
    	return "A carcass, lying in stark stillness, bores the weight of mortality.";
    }
    public String toString() {
    	return "Carcass";
    }
}
