package Location;

import Item.Item;
import Item.Basilic;

public class WC extends DecorObjet{
	public WC(int x, int y) {
		super((Item)new Basilic(), x, y);
	}

    public String getDescription() {
    	return "A toilet where you can hear the voice of a young girl.";
    }
    public String toString() {
    	return "WC";
    }
}
