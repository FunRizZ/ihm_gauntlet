package Location;

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
    public boolean itMe(String s){
    	System.out.println(s);
    	switch(s) {
    	case "Vase": 
    		return true;
    	default : 
    		return false;
    	}
    }
}
