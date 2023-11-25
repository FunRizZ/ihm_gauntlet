package Location;

import Game_pack.OwnException;

public class Table extends DecorObjet{
	
    public void look(){
        System.out.println("i'm a table");
    }
    @Override
    public DecorObjet itMe(String s) throws OwnException {
    	switch(s) {
    	case "Table": 
    		return (DecorObjet)this;
    	default : 
    		throw new OwnException("itMe",s +" not reconized, class Table");
    	}
    }
}
