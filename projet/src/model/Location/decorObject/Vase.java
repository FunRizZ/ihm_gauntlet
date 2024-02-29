package model.Location.decorObject;

import model.Item.BeastlyShield;

public class Vase extends DecorObjet {
	public Vase(int x, int y) {
		super(new BeastlyShield(), x, y);
	}

	@Override
    public String getDescription() {
    	return "An old vase with a magnificent design which represents all the wealth of the castle.";
    }
	@Override
    public String toString() {
    	return "Vase";
    }
}
