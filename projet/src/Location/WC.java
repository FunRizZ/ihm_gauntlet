package Location;

import Item.Item;
import Item.Basilic;

public class WC extends DecorObjet{
	public WC() {
		super((Item)new Basilic());
	}
    public void look(){
        System.out.println("i'm a wc");
    }
    @Override
    public boolean itMe(String s){
    	switch(s) {
    	case "Wc": 
    		return true;
    	default : 
    		return false;
    	}
    }
}
