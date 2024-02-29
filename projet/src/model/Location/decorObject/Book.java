package model.Location.decorObject;

import model.Item.Map;

public class Book extends DecorObjet {
	
	public Book(int x, int y) {
		super(new Map(), x, y);
	}
	@Override
    public String getDescription() {
    	return "An old book, weathered and worn with age, exuded an eerie aura as wisps of dark smoke";
    }
	@Override
    public String toString() {
    	return "Book";
    }
}
