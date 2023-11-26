package Location;

import Game_pack.Lookable;
import Item.Item;

public abstract class DecorObjet implements Lookable{
    public Item item;
    
    public DecorObjet(Item item) {
    	this.item = item;
    }
    public DecorObjet() {
    	this(null);
    }
    public Item take() {
    	Item i = this.item;
    	this.item = null;
    	return i;
    }
    public void look(){
        String dest = this.getDescription() + "\n\t";
        if (this.item != null) {dest += "with "+ this.item;}
        System.out.println(dest);
    }
    public boolean isMe(String st) {
    	return st.equals(this.toString());
    }
    public abstract String toString();
    public abstract String getDescription();
}
