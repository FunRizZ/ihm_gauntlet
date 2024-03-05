package model.location.decorObject;

import model.item.Basilic;

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
