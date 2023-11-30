package Location;

import Item.DeadraHammer;
import Item.Item;

public class Table extends DecorObjet{
	public Table() {
		super((Item)new DeadraHammer());
	}

    public String getDescription() {
    	return "An Table in a wondeful oak wood probably dated about four hundred years ago.";
    }
    public String toString() {
    	return "Table";
    }
}
