package Location;

import Item.Item;
import Item.Basilic;

public class WC extends DecorObjet{
	public WC() {
		super((Item)new Basilic());
	}

    public String getDescription() {
    	return "A toilet where you can hear the voice of a young girl ";
    }
    public String toString() {
    	return "WC";
    }
}
