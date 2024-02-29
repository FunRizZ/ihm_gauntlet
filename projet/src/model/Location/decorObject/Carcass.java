package model.Location.decorObject;

import model.Item.Item;

public class Carcass extends DecorObjet {
	public Carcass(Item i, int x, int y) {
		super(i, x, y);
	}
	public Carcass(int x, int y) {
		this(null, x, y);
	}
	@Override
    public String getDescription() {
    	return "A carcass, lying in stark stillness, bores the weight of mortality.";
    }
	@Override
    public String toString() {
    	return "Carcass";
    }
}
