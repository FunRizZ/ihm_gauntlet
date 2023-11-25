package Location;

import Game_pack.OwnException;
import Item.Item;
import Item.BeastlyShield;

public class Vase extends DecorObjet{
	public Vase() {
		super((Item)new BeastlyShield());
	}
    public void look(){
        System.out.println("i'm a vase");
    }
    @Override
    public DecorObjet itMe(String s) throws OwnException {
    	switch(s) {
    	case "Vase": 
    		return (DecorObjet)this;
    	default : 
    		throw new OwnException("itMe",s +" not reconized, class Vase");
    	}
    }
}
