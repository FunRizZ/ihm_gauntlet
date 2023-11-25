package Location;

import Game_pack.OwnException;
import Item.Item;
import Item.key;

public class Cupboard extends DecorObjet{
	public Cupboard() {
		super((Item)new key());
	}
    public void look(){
        System.out.println("i'm a cupboard");
    }
    @Override
    public DecorObjet itMe(String s) throws OwnException {
    	switch(s) {
    	case "Cupboard": 
    		return (DecorObjet)this;
    	default : 
    		throw new OwnException("itMe",s +" not reconized, class Cupboard");
    	}
    }
}
