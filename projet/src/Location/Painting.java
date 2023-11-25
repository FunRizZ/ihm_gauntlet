package Location;

import Game_pack.OwnException;

public class Painting extends DecorObjet{
	public Painting() {
		super();
	}
	
    public void look(){
        System.out.println("i'm a painting");
    }
    @Override
    public DecorObjet itMe(String s) throws OwnException {
    	switch(s) {
    	case "Painting": 
    		return (DecorObjet)this;
    	default : 
    		throw new OwnException("itMe",s +" not reconized, class Painting");
    	}
    }
}
