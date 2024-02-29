package model.Location.decorObject;

import model.Item.Basilic;

public class WC extends DecorObjet {
	public WC(int x, int y) {
		super(new Basilic(), x, y);
	}
	@Override
    public String getDescription() {
    	return "A toilet where you can hear the voice of a young girl.";
    }
	@Override
    public String toString() {
    	return "WC";
    }
}
