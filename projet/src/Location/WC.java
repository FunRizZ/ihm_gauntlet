package Location;

import Game_pack.OwnException;
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
    public DecorObjet itMe(String s) throws OwnException {
    	switch(s) {
    	case "Wc": 
    		return (DecorObjet)this;
    	default : 
    		throw new OwnException("itMe",s +" not reconized, class Wc");
    	}
    }
}
