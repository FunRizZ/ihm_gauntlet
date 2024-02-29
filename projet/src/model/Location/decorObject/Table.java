package model.Location.decorObject;

import model.Item.DeadraHammer;

public class Table extends DecorObjet {
	public Table(int x, int y) {
		super(new DeadraHammer(), x, y);
	}

    public String getDescription() {
    	return "An table in a wondeful oak wood probably dated about four hundred years ago.";
    }
    public String toString() {
    	return "Table";
    }
}
