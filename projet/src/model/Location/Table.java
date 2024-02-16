package model.Location;

import model.Item.DeadraHammer;
import model.Item.Item;

public class Table extends DecorObjet{
	public Table(int x, int y) {
		super((Item)new DeadraHammer(), x, y);
	}

    public String getDescription() {
    	return "An table in a wondeful oak wood probably dated about four hundred years ago.";
    }
    public String toString() {
    	return "Table";
    }
}
