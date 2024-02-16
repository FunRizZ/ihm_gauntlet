package model.Location;

import model.Item.Item;
import model.Item.Map;

public class Book extends DecorObjet{
	
	public Book(int x, int y) {
		super((Item)new Map(), x, y);
	}
	
    public String getDescription() {
    	return "An old book, weathered and worn with age, exuded an eerie aura as wisps of dark smoke";
    }
    public String toString() {
    	return "Book";
    }
}
