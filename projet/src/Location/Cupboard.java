package Location;


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
    public boolean itMe(String s){
    	switch(s) {
    	case "Cupboard": 
    		return true;
    	default : 
    		return false;
    	}
    }
}
