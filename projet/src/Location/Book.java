package Location;

import Item.Item;
import Item.Map;

public class Book extends DecorObjet{
	
	public Book() {
		super((Item)new Map());
	}
	
    public void look(){
        System.out.println("i'm a book");
    }
    @Override
    public boolean itMe(String s){
    	switch(s) {
    	case "Book": 
    		return true;
    	default : 
    		return false;
    	}
    }
}
