package Location;

import Item.Item;
import Item.Map;

public class Book extends DecorObjet{
	
	public Book() {
		super((Item)new Map());
	}
	
    @Override
    public boolean isMe(String s){
    	switch(s) {
    	case "Book": 
    		return true;
    	default : 
    		return false;
    	}
    }
    public String getDescription() {
    	return "An old book, weathered and worn with age, exuded an eerie aura as wisps of dark smoke";
    }
    public String toString() {
    	return "Book";
    }
}
