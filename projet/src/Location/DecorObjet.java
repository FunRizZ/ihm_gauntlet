package Location;

import Game_pack.Lookable;
import Game_pack.OwnException;
import Item.Item;

public abstract class DecorObjet implements Lookable{
    public Item item;
    
    public DecorObjet(Item item) {
    	this.item = item;
    }
    public DecorObjet() {
    	this(null);
    }
    public abstract DecorObjet itMe(String s) throws OwnException;
}
