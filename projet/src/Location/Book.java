package Location;


import Game_pack.OwnException;
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
    public DecorObjet itMe(String s) throws OwnException {
    	switch(s) {
    	case "Book": 
    		return (DecorObjet)this;
    	default : 
    		throw new OwnException("itMe",s +" not reconized, class Book");
    	}
    }
}
